/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

/**
 *
 * @author Sciencegamer
 */


import java.util.ArrayList;
import modelos.entidades.Despesas;

public interface IDespesas {
    
    void incluir(Despesas objeto) throws Exception;
    void alterar(Despesas objeto) throws Exception;
    void excluir(int id) throws Exception;
    Despesas consultar(int id) throws Exception;
    ArrayList<Despesas> listagem() throws Exception;
}

