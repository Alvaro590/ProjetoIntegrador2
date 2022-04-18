/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import modelos.entidades.Banco;
import persistencia.BancoPersistencia;
import modelos.interfaces.IBanco;

public class BancoControle implements IBanco {

    BancoPersistencia objBancoDao = new BancoPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Bancos.txt");

    @Override
    public void incluir(Banco objeto) throws Exception {
        try {
            Banco aux1 = objBancoDao.consultarPorId(objeto.getId());
            Banco aux2 = objBancoDao.consultarPorDescricao(objeto.getDescricao());
            if(objeto.getId()<1){
                throw new Exception("Identificador inválido");
            }
            if (aux1 == null && aux2 == null) {
                objBancoDao.incluir(objeto);
            } else {
                throw new Exception("O id ou descrição desse banco já existem");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterarPorId(int id, Banco objeto) throws Exception {
        try {
            Banco aux = objBancoDao.consultarPorId(objeto.getId());
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                objBancoDao.alterarPorId(id, objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            Banco aux = objBancoDao.consultarPorId(id);
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                objBancoDao.apagarPorId(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Banco consultarPorId(int id) throws Exception {
        try {
            Banco aux = objBancoDao.consultarPorId(id);
            if (aux == null) {
                throw new Exception("Não existe banco com esse id");
            } else {
                return objBancoDao.consultarPorId(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void alterarPorDescricao(Banco objeto)throws Exception {
        try {
            Banco aux = objBancoDao.consultarPorDescricao(objeto.getDescricao());
            if (aux == null) {
                throw new Exception("Não existe banco com essa descrição");
            } else {
                objBancoDao.alterarPorDescricao(aux.getId(), objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
        return objBancoDao.listagem();
    }

}
