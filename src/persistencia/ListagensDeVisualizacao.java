/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.entidades.Despesas;
import modelos.entidades.Receitas;

/**
 *
 * @author Sciencegamer
 */
public class ListagensDeVisualizacao {

    public ArrayList<Receitas> listagemReceitas() throws Exception {
        try {
            ArrayList<Receitas> arrayR = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Receitas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Receitas aux = new Receitas();
                String vetorString[] = linha.split(";");

                int identificador = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                String conta = vetorString[4];
                String cartao = vetorString[5];

                aux.setId(identificador);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setConta(conta);
                aux.setCartao(cartao);

                arrayR.add(aux);
            }
            br.close();
            return arrayR;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public ArrayList<Despesas> listagemDespesas() throws Exception {
        try {
            ArrayList<Despesas> arrayD = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Despesas aux = new Despesas();
                String vetorString[] = linha.split(";");

                int id = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble("-" + vetorString[2]);
                String data = vetorString[3];
                String cartao = vetorString[6];
                String conta = vetorString[7];
                String fixa = vetorString[5];

                aux.setId(id);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setCartao(cartao);
                aux.setConta(conta);
                aux.setFixa(fixa);

                arrayD.add(aux);
            }
            br.close();
            return arrayD;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public ArrayList<String> listagemMensal(String mes) throws Exception {
        try {
            ArrayList<String> arrayMensal = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String aux = "";
                String vetorString[] = linha.split(";");
                String comparador = vetorString[3].substring(3, 5);
                if (mes.equals(comparador)) {
                    aux += vetorString[3] + ";";
                    aux += "-" + vetorString[2] + ";";
                    aux += vetorString[1] + ";";
                    aux += vetorString[7] + ";";
                    aux += vetorString[6] + ";";
                    aux += vetorString[0];
                    arrayMensal.add(aux);

                }

            }
            FileReader fr2 = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Receitas.txt");
            //Criar o buffer do arquivo
            BufferedReader br2 = new BufferedReader(fr2);
            String linha2 = "";
            while ((linha2 = br2.readLine()) != null) {
                String aux = "";
                String vetorString[] = linha.split(";");
                String comparador = vetorString[3].substring(3, 5);
                if (mes.equals(comparador)) {
                    aux += vetorString[3] + ";";
                    aux += vetorString[2] + ";";
                    aux += vetorString[1] + ";";
                    aux += vetorString[4] + ";";
                    aux += vetorString[5] + ";";
                    aux += vetorString[0];
                    arrayMensal.add(aux);

                }

            }
            br.close();

            return arrayMensal;

        } catch (Exception erro) {
            throw erro;
        }
    }

    public double retornaFatura(int idDoCartao) throws Exception {
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {

                String vetorString[] = linha.split(";");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

                int idCartao = Integer.parseInt(vetorString[4]);
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                int parcela = Integer.parseInt(vetorString[6]);

                CartaoPersistencia cPersist = new CartaoPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");

                int fechamento = Integer.parseInt(cPersist.retornaAtributoCartao(idDoCartao, 4));

                Date dataDaConta = dateFormat.parse(data);

                Date hoje = new Date();
                int mesAtual = hoje.getMonth() + 1;

                int anoAtual = hoje.getYear() + 1900;

                int diaAtual = Calendar.DAY_OF_MONTH;

                int diaDespesa = Integer.parseInt(data.substring(0, 2));
                int mesDespesa = Integer.parseInt(data.substring(3, 5));
                int anoDespesa = Integer.parseInt(data.substring(6, 8));

                //int pagamento = Integer.parseInt(cartaoPersistencia.retornaAtributoCartao(Integer.parseInt(objeto.getCartao()), 5));               
                if (idCartao == idDoCartao) {
                    if ((anoAtual - 2000) == anoDespesa) {
                        if (parcela + mesDespesa >= mesAtual) {
                            return valor / parcela;
                        } else if (parcela + mesDespesa - 1 == mesAtual) {
                            if (diaDespesa > fechamento) {
                                return valor / parcela;
                            }
                        }
                    } else if ((anoAtual - 2000) > anoDespesa) {
                        int diferenca = anoAtual - anoDespesa;
                        int mesesPassados = 12 * diferenca + mesAtual - mesDespesa;
                        if (parcela >= mesesPassados) {
                            return valor / parcela;
                        } else if (parcela == mesesPassados - 1) {
                            if (diaDespesa > fechamento) {
                                return valor / parcela;
                            }
                        }
                    }
                }

            }
            br.close();
            return 0;
        } catch (Exception erro) {
            throw erro;
        }
    }

}
