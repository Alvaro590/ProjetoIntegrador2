/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import modelos.entidades.Cartao;
import modelos.interfaces.ICartao;
import persistencia.CartaoPersistencia;

public class CartaoControle implements ICartao {

    CartaoPersistencia cpersist = new CartaoPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");

    @Override
    public void incluir(Cartao objeto) throws Exception {
        try {
            if(objeto.getId()==0){
                throw new Exception("O identificador do cartão não pode ser nulo");
            }
            if(objeto.getDiaDoFechamento()==0||objeto.getDiaDoFechamento()>28){
                throw new Exception("Dia do fechamento da fatura inválido");
            }
            if(objeto.getDiaDoPagamento()==0||objeto.getDiaDoPagamento()>28){
                throw new Exception("Dia do pagamento da fatura inválido");
            }            
                
            Cartao aux = cpersist.consultarPorId(objeto.getId());            
            
            if (aux == null) {
                cpersist.incluir(objeto);
            } else {
                throw new Exception("Este identificador de cartão já existe");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            Cartao aux = cpersist.consultarPorId(id);
            if (aux == null) {
                throw new Exception("Não existe cartão com esse id");

            } else {
                cpersist.apagarPorId(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Cartao consultarPorId(int id) throws Exception {
        try {
            Cartao aux = cpersist.consultarPorId(id);
            if (aux == null) {
                throw new Exception("Não existe cartão com esse id");

            } else {
                return cpersist.consultarPorId(id);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Cartao> listagem() throws Exception {
        return cpersist.listagem();
    }

    @Override
    public void alterar(int id, Cartao objeto) throws Exception {
        try {
            Cartao aux = cpersist.consultarPorId(id);
            if (aux == null) {
                throw new Exception("Não existe cartão com esse id");
                
            } else {
                cpersist.alterar(id, objeto);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }
}
