/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.Conta;

/**
 *
 * @author Sciencegamer
 */
public interface IConta {
    void incluir(Conta objeto) throws Exception;
    void alterar(int id, Conta objeto) throws Exception;
    void apagar(int id) throws Exception;
    Conta consultar(int id) throws Exception;
    ArrayList<Conta> listagem() throws Exception; 
    
}
