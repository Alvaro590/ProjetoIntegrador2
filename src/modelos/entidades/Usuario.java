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
public class Usuario {

    private String nome;
    private String senha;
    

    public Usuario() {

    }

    public Usuario(String nome, String senha) {
        this.senha = senha;
        this.nome = nome;
    }
    
    
    
    public boolean compararUsuario(String nome, String senha){
        return this.nome.equals(nome)&&this.senha.equals(senha);
    }
    
    public boolean comparaSenha(String senha){
        return this.senha.equals(senha);
    }
    
    public boolean comparaNome(String nome){
        return this.nome.equals(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    @Override
    public String toString() {
        return nome + ";" + senha;
    }
    
    

}
