/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;

import modelos.entidades.Cartao;

/**
 *
 * @author Sciencegamer
 */
public interface ICartao {
    
    void incluir(Cartao objeto) throws Exception;
    void alterar(int id, Cartao objeto) throws Exception;
    void apagarPorId(int id) throws Exception;
    Cartao consultarPorId(int id) throws Exception;
    ArrayList<Cartao> listagem() throws Exception;  
    
}
