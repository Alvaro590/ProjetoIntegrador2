/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import modelos.entidades.Banco;
import java.util.ArrayList;
// Biblioteca para manupulacao de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import modelos.interfaces.IBanco;


public class BancoPersistencia implements IBanco{
    //Atributo
    private String nomeDoArquivoDadosNoDisco = "";
    //Metodos
    public BancoPersistencia(String nomeDoArquivoDadosNoDisco){
        this.nomeDoArquivoDadosNoDisco = nomeDoArquivoDadosNoDisco;
    }

    @Override
    public void incluir(Banco objeto) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco,true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            bw.write(objeto.toString()+ "\n");
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterarPorId(int id, Banco objeto) throws Exception {
        try {
            apagarPorId(id);
            incluir(objeto);

        } catch (Exception e) {
            throw e;
        }
    }    
    
    public void alterarPorDescricao(int id, Banco objeto) throws Exception {
        try {
            apagarPorId(id);
            incluir(objeto);

        } catch (Exception e) {
            throw e;
        }
    }  

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for(int pos = 0; pos < arrayDosBancos.size(); pos++){
                if(id != arrayDosBancos.get(pos).getId()){
                    bw.write(arrayDosBancos.get(pos).toString()+ "\n");
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
        
        
    }    
    
    public Banco consultarPorDescricao(String descricao)throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Banco aux = new Banco();
            while((linha = br.readLine())!=null){
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String nomeDoBanco = vetorString[1];
                aux.setId(identificador);
                aux.setDescricao(nomeDoBanco);
                if(aux.getDescricao().equals(descricao) ){
                    return aux;
                }
            }
            aux = null;
            return aux;
        } catch (Exception erro) {
            throw erro;
        }finally{
            br.close();
        }
        
        
    }
    

    @Override
    public Banco consultarPorId(int id) throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Banco aux = new Banco();
            while((linha = br.readLine())!=null){
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String nomeDoBanco = vetorString[1];
                aux.setId(identificador);
                aux.setDescricao(nomeDoBanco);
                if(aux.getId() == id) return aux;
            }
            aux = null;
            return aux;
        } catch (Exception erro) {
            throw erro;
        }finally{
            br.close();
        }
        
        
    }
    

    @Override
    public  ArrayList<Banco> listagem() throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = new ArrayList<Banco>();
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while((linha = br.readLine())!=null){
                Banco aux = new Banco();
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String nomeDoBanco = vetorString[1];
                aux.setId(identificador);
                aux.setDescricao(nomeDoBanco);
                arrayDosBancos.add(aux);
            }
            br.close();
            return arrayDosBancos;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    
}
