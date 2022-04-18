/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;



/**
 *
 * @author Sciencegamer
 */
public class Cartao {
    
    private int id;
    private String numero;
    private String nome;
    private String validade;      
    private int diaDoFechamento;
    private int diaDoPagamento;
    private int cvv;
    private String bandeira;
    private double limite;
    private int agencia;
    private String conta;
    private double taxa;
    
    public Cartao(){
        
    }
    
    public Cartao(int id, String numero, String nome, String validade, int diaDoFechamento, int diaDoPagamento, int cvv, String bandeira, double limite, int agencia, String conta, double taxa){
        this.id= id;        
        this.numero = numero;
        this.nome= nome;
        this.validade= validade;
        this.diaDoFechamento= diaDoFechamento;
        this.diaDoPagamento= diaDoPagamento;
        this.cvv = cvv;
        this.bandeira= bandeira;        
        this.limite= limite;
        this.agencia=agencia;    
        this.conta = conta;  
        this.taxa = taxa;
    }  

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    } 

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaDoFechamento() {
        return diaDoFechamento;
    }

    public void setDiaDoFechamento(int diaDoFechamento) {
        this.diaDoFechamento = diaDoFechamento;
    }

    public int getDiaDoPagamento() {
        return diaDoPagamento;
    }

    public void setDiaDoPagamento(int diaDoPagamento) {
        this.diaDoPagamento = diaDoPagamento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }  

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        
    
    @Override
    public String toString() {
        return id + ";" + numero +";"+ nome+";"+ validade +";"+ diaDoFechamento +";"+ diaDoPagamento + ";" + cvv +";"+ bandeira+";"+ limite +";"+ agencia +";"+conta+";"+taxa;
    }

    
//    private int id;
//    private int numero;
//    private String nome;
//    private String validade;      
//    private int diaDoFechamento;
//    private int diaDoPagamento;
//    private int cvv;
//    private String bandeira;
//    private String limite;
//    private int agencia;
//    private String conta;
//    private double taxa;

    
    
    
    
    
    
}
