/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.entidades.Conta;
import modelos.interfaces.IConta;
import persistencia.ContaPersistencia;

/**
 *
 * @author Sciencegamer
 */
public class ContaControle implements IConta{
    
    ContaPersistencia cPersistencia = new  ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");

    @Override
    public void incluir(Conta objeto) throws Exception {
        try {
            Conta aux1 = cPersistencia.consultar(objeto.getId());
            if(objeto.getId()==0){
                throw new Exception("O identificador não pode ser nulo");
            } 
            
            if(objeto.getLimite()==0){
                 throw new Exception("O limite não pode ser nulo");
            }
            
            if(objeto.getSaldo()<0&& objeto.getSaldo()*(-1)>objeto.getLimite()){
                throw new Exception("O saldo não pode ser menor que o limite");
            }
            
            if (aux1 == null ) {
                cPersistencia.incluir(objeto);
            } else {
                throw new Exception("Esse id já existe");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(int id, Conta objeto) throws Exception {
        try {
            Conta aux = cPersistencia.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                cPersistencia.apagar(id);
                cPersistencia.incluir(objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagar(int id) throws Exception {
        try {
            Conta aux = cPersistencia.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                cPersistencia.apagar(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Conta consultar(int id) throws Exception {
         try {
            Conta aux = cPersistencia.consultar(id);
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                return cPersistencia.consultar(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Conta> listagem() throws Exception {
        return cPersistencia.listagem();
    }
    
}
