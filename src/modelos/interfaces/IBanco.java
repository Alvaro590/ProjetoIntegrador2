/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import modelos.entidades.Banco;
import java.util.ArrayList;


public interface IBanco {
    void incluir(Banco objeto) throws Exception;
    void alterarPorId(int id, Banco objeto) throws Exception;
    void apagarPorId(int id) throws Exception;
    Banco consultarPorId(int id) throws Exception;
    ArrayList<Banco> listagem() throws Exception;  
}
