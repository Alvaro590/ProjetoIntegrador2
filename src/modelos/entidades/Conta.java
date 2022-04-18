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
public class Conta {
    
    private int id;
    private double saldo;
    private String banco;
    private double limite;
    private double taxa;    
    
    public Conta(){       
        
    }
    
    public Conta(int id, double saldo, String banco, double limite, double taxa) {
        this.id = id;
        this.saldo = saldo;
        this.banco = banco;
        this.limite= limite;
        this.taxa= taxa;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
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
    
    
    @Override
    public String toString() {
        return id + ";" + saldo + ";" + banco+ ";" + limite+ ";" + taxa;
    }
    
        
    
}
