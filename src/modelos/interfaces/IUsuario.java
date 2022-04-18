/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.Usuario;


public interface IUsuario {
    void incluirUsuario (Usuario objeto) throws Exception;
    ArrayList<Usuario> listagem() throws Exception; 
    
     
    
}
