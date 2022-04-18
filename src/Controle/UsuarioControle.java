/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelos.entidades.Usuario;
import modelos.interfaces.IUsuario;

import persistencia.UsuarioPersistencia;

public class UsuarioControle implements IUsuario {

    private UsuarioPersistencia persistencia = new UsuarioPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Usuarios.txt");

    @Override
    public void incluirUsuario(Usuario objeto) throws Exception {

        boolean senhaValida;
        String senha = objeto.getSenha();
        senhaValida = senha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[#?!@%^&$*-]).{8,50}$");

        if (senhaValida) {

            persistencia.incluirUsuario(objeto);
        } else {
            throw new Exception("Dados incorretos, a senha deve ter uma letra, um número, um caracter especial e, no mínimo, 8 caracteres");
        }

    }

    public void alterarSenha(String senha1, String confirmacaoSenha, String nome) throws Exception {
        ArrayList<Usuario> aux = persistencia.listagem();

        if (aux.isEmpty()) {
            throw new Exception("Nenhum usuário cadastrado");
        }
        if (nome == null) {
            throw new Exception("Nome de usuário não inserido");
        }
        if (senha1 == null) {
            throw new Exception("Senha não inserida");
        }
        if (confirmacaoSenha == null) {
            throw new Exception("Confirmação de senha não inserida");
        }
        if (!senha1.equals(confirmacaoSenha)) {
            throw new Exception("As senhas digitadas são diferentes");
        }

        int c = 0;
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).comparaNome(nome)) {
                c++;
            }
        }
        if (c == 0) {
            throw new Exception("Nome de usuário não cadastrado");
        }

        Usuario novo = new Usuario(nome, senha1);
        boolean senhaValida = senha1.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[#?!@%^&$*-]).{8,50}$");
        if (senhaValida) {
            for (int i = 0; i < aux.size(); i++) {
                if (aux.get(i).comparaNome(novo.getNome())) {
                    aux.set(i, novo);
                }
            }

        } else {
            throw new Exception("A senha precisa ter, no mínimo, uma letra, um número, um caracterer especial e 8 caracteres");
        }

    }

    public ArrayList<Usuario> listagem() throws Exception {
        return persistencia.listagem();
    }

}
