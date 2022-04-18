/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.util.ArrayList;
import modelos.entidades.Conta;
import modelos.entidades.Despesas;
import persistencia.CartaoPersistencia;
import persistencia.ContaPersistencia;
import persistencia.DespesasPersistencia;
import persistencia.ListagensDeVisualizacao;

/**
 *
 * @author Sciencegamer
 */
public class Teste {

    public static void main(String[] args) throws Exception {
        
        double valor =10;        
        int id =1;
        
        ContaPersistencia contaPersist = new ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");
                
        Conta conta = contaPersist.retornaConta(id);
        conta.setSaldo(conta.getSaldo()+valor);
        
        contaPersist.apagar(id);
        contaPersist.incluir(conta);
        
        
        ListagensDeVisualizacao b = new ListagensDeVisualizacao();
        DespesasPersistencia nova = new DespesasPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
        CartaoPersistencia cardPersist = new CartaoPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");
        
        try{            
            //Despesas d1 = new Despesas(20, Aluguel, 100,);           
            
        }catch(Exception erro) {
            throw erro;
            
        }
        
        
        
    }

}
