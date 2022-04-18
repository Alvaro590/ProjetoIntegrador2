/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.entidades.Conta;
import modelos.entidades.Despesas;
import persistencia.DespesasPersistencia;
import modelos.interfaces.IDespesas;
import persistencia.CartaoPersistencia;
import persistencia.ContaPersistencia;
import persistencia.ListagensDeVisualizacao;

public class DespesasControle implements IDespesas {

    DespesasPersistencia objDespesasDao = new DespesasPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
    ContaPersistencia contaPersistencia = new ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");
    CartaoPersistencia cartaoPersistencia = new CartaoPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");
    ListagensDeVisualizacao listaViz = new ListagensDeVisualizacao();

    @Override
    public void incluir(Despesas objeto) throws Exception {
        if (objeto.getId() < 1) {
            throw new Exception("O identificador não pode ser nulo");
        }
        if (objeto.getParcelas() < 1) {
            throw new Exception("O número de parcelas não pode ser igual a 0");
        }

        Despesas aux = objDespesasDao.consultar(objeto.getId());
        if (aux != null) {
            throw new Exception("Este id de Despesas já consta nos arquivos");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dataDaDespesa = dateFormat.parse(objeto.getData());

        int fechamento = Integer.parseInt(cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 4));

        Date hoje3 = new Date();
        int mesAtual = hoje3.getMonth() + 1;
        int mesMaior = mesAtual;
        int mesMenor = mesAtual;
        int anoAtual = hoje3.getYear() + 1900;
        int anoMaior = anoAtual;
        int anoMenor = anoAtual;
        int diaAtual = Calendar.DAY_OF_MONTH;

        if (mesAtual == 12) {
            if (diaAtual > fechamento) {
                anoMaior += 1;
                mesMaior = 1;
            } else {
                mesMenor -= 1;
            }
        } else if (mesAtual == 1) {
            if (diaAtual > fechamento) {
                mesMaior += 1;
            } else {
                anoMenor -= 1;
                mesMenor = 12;
            }
        } else {
            if (diaAtual > fechamento) {
                mesMaior += 1;
            } else {
                mesMenor -= 1;
            }
        }

        int diaDespesa = Integer.parseInt(objeto.getData().substring(0, 2));
        int mesDespesa = Integer.parseInt(objeto.getData().substring(3, 5));
        int anoDespesa = Integer.parseInt(objeto.getData().substring(6, 8));

        int parcelasPagasAux;
        if ((anoAtual - 2000) == anoDespesa) {
            parcelasPagasAux = mesAtual - mesDespesa;
        } else {
            int diferenca = anoAtual - anoDespesa - 2000;
            parcelasPagasAux = 12 * diferenca + mesAtual - mesDespesa;

        }

        int pagamento = Integer.parseInt(cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 5));

        if (mesDespesa == mesAtual) {
            if (diaAtual > pagamento) {
                if (diaDespesa < fechamento) {
                    parcelasPagasAux += 1;
                }
            }
        } else {
            if (diaAtual > pagamento) {
                parcelasPagasAux += 1;
            }
            if (diaDespesa > fechamento) {
                parcelasPagasAux -= 1;
            }
        }

        if (parcelasPagasAux > objeto.getParcelas()) {
            parcelasPagasAux = objeto.getParcelas();
        }
        double valorPago;
        if (cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 8).equals("0.0")) {
            valorPago = objeto.getValor();
        } else {
            valorPago = (objeto.getValor() / objeto.getParcelas()) * parcelasPagasAux;
        }

        String hojeAux = diaAtual + "/" + mesAtual + "/" + anoAtual;
        String comparadorMaiorAux = fechamento + "/" + mesMaior + "/" + anoMaior;
        String comparadorMenorAux = fechamento + "/" + mesMenor + "/" + anoMenor;

        Date comparadorMaior = dateFormat.parse(comparadorMaiorAux);
        Date hoje = dateFormat.parse(hojeAux);
        Date comparadorMenor = dateFormat.parse(comparadorMenorAux);

        if (objeto.getParcelas() != 1 && cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 8).equals("0.0")) {
            throw new Exception("Apenas cartões de crédito podem parcelar compras");
        }

        //Se conta foi paga com cartão de crédito
        if (Integer.parseInt(objeto.getCartao()) != 0 && !cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 8).equals("0.0")) {

            //adicionar na condição se parcela alcança data
            if (dataDaDespesa.before(hoje) ) {

                double fatura = listaViz.retornaFatura(Integer.parseInt(objeto.getCartao())) + (objeto.getValor() / objeto.getParcelas());
                String limiteAux = cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 8);
                double limite = Double.parseDouble(limiteAux);

                //Testando limite do cartão
                if (fatura > limite) {
                    throw new Exception("Essa conta ultrapassa o limite do cartão");
                } else if (fatura > limite * 0.7) {
                    JOptionPane.showMessageDialog(null, "Limite de 70% do cartão " + objeto.getCartao() + " ultrapassado", "Aviso", 1);

                }
            }
        }

        //Update saldo
        if (Integer.parseInt(objeto.getConta()) != 0) {
            Conta conta = contaPersistencia.retornaConta(Integer.parseInt(objeto.getConta()));

            //Se data é anterior a hoje
            if (dataDaDespesa.before(hoje)) {
                double saldo = conta.getSaldo();
                double limite = conta.getLimite();
                double resultado = (saldo - valorPago);

                if (resultado < 0) {
                    if (resultado * -1 > limite) {
                        throw new Exception("A conta registrada não tem saldo para incluir essa despesa");
                    }
                }

                conta.setSaldo(conta.getSaldo() - valorPago);
                contaPersistencia.apagar(Integer.parseInt(objeto.getConta()));
                contaPersistencia.incluir(conta);

            }
        }
        objDespesasDao.incluir(objeto);

    }

    @Override
    public void alterar(Despesas objeto) throws Exception {
        try {
            if (objeto.getParcelas() < 1) {
                throw new Exception("O número de parcelas não pode ser negativo ou igual a 0");
            }
            Despesas aux = objDespesasDao.consultar(objeto.getId());
            if (aux == null) {
                throw new Exception("Não existe despesa com esse id");

            } else {
                objDespesasDao.alterar(objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            Despesas aux = objDespesasDao.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe despesa com esse id");

            } else {
                Despesas aux1 = objDespesasDao.retornaDespesa(id);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                Date dataDaDespesa = dateFormat.parse(aux1.getData());
                int diaDespesa = Integer.parseInt(aux1.getData().substring(0, 2));
                int mesDespesa = Integer.parseInt(aux1.getData().substring(3, 5));
                int anoDespesa = Integer.parseInt(aux1.getData().substring(6, 8));

                Date hojeAux1 = new Date();
                int mesAtual = hojeAux1.getMonth() + 1;
                int anoAtual = hojeAux1.getYear() + 1900;
                int diaAtual = Calendar.DAY_OF_MONTH;

                int parcelasPagasAux;
                if ((anoAtual - 2000) == anoDespesa) {
                    parcelasPagasAux = mesAtual - mesDespesa;
                } else {
                    int diferenca = anoAtual - anoDespesa - 2000;
                    parcelasPagasAux = 12 * diferenca + mesAtual - mesDespesa;

                }

                int fechamento = Integer.parseInt(cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(aux1.getCartao()), 4));
                int pagamento = Integer.parseInt(cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(aux1.getCartao()), 5));

                if (mesDespesa == mesAtual) {
                    if (diaAtual > pagamento) {
                        if (diaDespesa < fechamento) {
                            parcelasPagasAux += 1;
                        }
                    }
                } else {
                    if (diaAtual > pagamento) {
                        parcelasPagasAux += 1;
                    }
                    if (diaDespesa > fechamento) {
                        parcelasPagasAux -= 1;
                    }
                }

                double valorPago;
                if (cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(aux1.getCartao()), 8).equals("0.0")) {
                    valorPago = aux1.getValor();
                } else {
                    valorPago = (aux1.getValor() / aux1.getParcelas()) * parcelasPagasAux;
                }

                String hojeAux2 = diaAtual + "/" + mesAtual + "/" + anoAtual;

                Date hoje = dateFormat.parse(hojeAux2);

                if (Integer.parseInt(aux1.getConta()) != 0) {
                    Conta conta = contaPersistencia.retornaConta(Integer.parseInt(aux1.getConta()));

                    //Se data é anterior a hoje
                    if (dataDaDespesa.before(hoje)) {
                        conta.setSaldo(conta.getSaldo() + valorPago);
                        contaPersistencia.apagar(id);
                        contaPersistencia.incluir(conta);

                    }

                }
            }
            objDespesasDao.excluir(id);
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public Despesas consultar(int id) throws Exception {
        try {
            Despesas aux = objDespesasDao.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe despesa com esse id");

            } else {
                return objDespesasDao.consultar(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Despesas> listagem() throws Exception {
        return objDespesasDao.listagem();
    }

}
