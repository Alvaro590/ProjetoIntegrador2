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
import modelos.entidades.Conta;
import modelos.entidades.Receitas;
import modelos.interfaces.IReceitas;
import persistencia.ContaPersistencia;
import persistencia.ReceitasPersistencia;

public class ReceitasControle implements IReceitas {

    ReceitasPersistencia objReceitasDao = new ReceitasPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Receitas.txt");

    @Override
    public void criar(Receitas objeto) throws Exception {
        try {
            if (objeto.getId() == 0) {
                throw new Exception("O identificador da receita não pode ser nulo");
            }
            Receitas aux = objReceitasDao.consultar(objeto.getId());

            if (aux == null) {
                ContaPersistencia contaPersistencia = new ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                Date dataDaReceita = dateFormat.parse(objeto.getData());

                Date hoje3 = new Date();
                int mesAtual = hoje3.getMonth() + 1;
                int anoAtual = hoje3.getYear() -100;
                int diaAtual = Calendar.DAY_OF_MONTH;

                String hojeAux = diaAtual + "/" + mesAtual + "/" + anoAtual;
                Date hoje = dateFormat.parse(hojeAux);
                //Update saldo
                if (Integer.parseInt(objeto.getConta()) != 0) {
                    Conta conta = contaPersistencia.retornaConta(Integer.parseInt(objeto.getConta()));

                    //Se data é anterior a hoje
                    if (dataDaReceita.before(hoje)) {                       

                        conta.setSaldo(conta.getSaldo() + objeto.getValor());
                        contaPersistencia.apagar(Integer.parseInt(objeto.getConta()));
                        contaPersistencia.incluir(conta);

                    }
                }
                objReceitasDao.criar(objeto);
            } else {
                throw new Exception("Este id já consta nos arquivos");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Receitas objeto) throws Exception {
        try {
            Receitas aux = objReceitasDao.consultar(objeto.getId());
            if (aux == null) {
                throw new Exception("Não existe receita com esse id");

            } else {
                
                objReceitasDao.alterar(objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void deletar(int id) throws Exception {
        try {
            Receitas aux = objReceitasDao.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe receita com esse id");

            } else {
                
                ContaPersistencia contaPersistencia = new ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");
                Receitas r1 = objReceitasDao.retornaReceita(id);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                Date dataDaReceita = dateFormat.parse(r1.getData());

                Date hoje3 = new Date();
                int mesAtual = hoje3.getMonth() + 1;
                int anoAtual = hoje3.getYear() -100;
                int diaAtual = Calendar.DAY_OF_MONTH;

                String hojeAux = diaAtual + "/" + mesAtual + "/" + anoAtual;
                Date hoje = dateFormat.parse(hojeAux);
                //Update saldo
                if (Integer.parseInt(r1.getConta()) != 0) {
                    Conta conta = contaPersistencia.retornaConta(Integer.parseInt(r1.getConta()));

                    //Se data é anterior a hoje
                    if (dataDaReceita.before(hoje)) {                       

                        conta.setSaldo(conta.getSaldo() - r1.getValor());
                        contaPersistencia.apagar(Integer.parseInt(r1.getConta()));
                        contaPersistencia.incluir(conta);

                    }
                }
                
                objReceitasDao.deletar(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Receitas consultar(int id) throws Exception {
        try {
            Receitas aux = objReceitasDao.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe receita com esse id");

            } else {
                return objReceitasDao.consultar(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Receitas> listagem() throws Exception {
        return objReceitasDao.listagem();
    }

}
