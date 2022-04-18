/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import java.util.Date;

public class Despesas {

    private int id;
    private String descricao;
    private double valor;
    private String data;
    private int parcelas;
    private String fixa;    
    private String cartao;
    private String conta;

    public Despesas() {
    }

    public Despesas(int id, String descricao, double valor, String data, String cartao, String fixa, int parcelas, String conta) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;        
        this.fixa= fixa;
        this.cartao = cartao;
        this.parcelas= parcelas;
        this.conta= conta;
    }   
      

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFixa() {
        return fixa;
    }    

    public void setFixa(String fixa) {
        this.fixa = fixa;
    }      
    
    @Override
    public String toString() {        
            return id + ";" + descricao + ";" + valor + ";" + data +";" + cartao +";"+ fixa +";"+ parcelas+";"+conta ;        
    }

}
