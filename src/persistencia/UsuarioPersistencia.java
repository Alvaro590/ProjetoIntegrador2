/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import modelos.entidades.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import modelos.interfaces.IUsuario;

public class UsuarioPersistencia implements IUsuario {

    private String nomeDoArquivoDadosNoDisco = "";

    public UsuarioPersistencia(String nomeDoArquivoDadosNoDisco) {
        this.nomeDoArquivoDadosNoDisco = nomeDoArquivoDadosNoDisco;
    }

    @Override
    public void incluirUsuario(Usuario objeto) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            bw.write(objeto.toString() + "\n");
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Usuario> listagem() throws Exception {
        try {
            ArrayList<Usuario> aux1 = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Usuario aux = new Usuario();
                String vetorString[] = linha.split(";");
                String nome = vetorString[0];
                String senha = vetorString[1];
                aux.setNome(nome);
                aux.setSenha(senha);
                aux1.add(aux);
            }
            br.close();
            return aux1;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void alterarSenha(Usuario novo, String nome) throws Exception {
        try {
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            apagarPorNome(nome);
            incluirUsuario(novo);
        } catch (Exception erro) {
            throw erro;
        }

    }

    public void apagarPorNome(String nome) throws Exception {
        try {
            ArrayList<Usuario> aux = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for (int pos = 0; pos < aux.size(); pos++) {
                if(!nome.equals(aux.get(pos).getNome())){
                    bw.write(aux.get(pos).toString()+ "\n");
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

}
