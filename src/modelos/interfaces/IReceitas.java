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
import modelos.entidades.Receitas;


public interface IReceitas {
    
    void criar(Receitas objeto) throws Exception;
    void alterar(Receitas objeto) throws Exception;
    void deletar(int id) throws Exception;
    Receitas consultar(int id) throws Exception;
    ArrayList<Receitas> listagem() throws Exception;
}
