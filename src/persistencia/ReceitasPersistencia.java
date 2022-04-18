/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.util.ArrayList;

// Biblioteca para manupulacao de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelos.entidades.Receitas;
import modelos.interfaces.IReceitas;


public class ReceitasPersistencia implements IReceitas{
    
    private String ReceitasTxt = "";
    
    //Construtor

    public ReceitasPersistencia(String arquivo) {
        this.ReceitasTxt = arquivo;
    }

    @Override
    public void criar(Receitas objeto) throws Exception {
         try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(ReceitasTxt,true);
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
    public void alterar(Receitas objeto) throws Exception {
        try {
            deletar(objeto.getId());
            criar(objeto);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletar(int id) throws Exception {
     try {
            ArrayList<Receitas> arrayDosBancos = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(ReceitasTxt);
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

    @Override
    public Receitas consultar(int id) throws Exception {
         BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(ReceitasTxt);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Receitas aux = new Receitas();
            while((linha = br.readLine())!=null){
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                String conta = vetorString[4];
                String cartao = vetorString[5];
                
                aux.setId(identificador);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setConta(conta);
                aux.setCartao(cartao);
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
    public ArrayList<Receitas> listagem() throws Exception {
         try {
            ArrayList<Receitas> arrayDasReceitas = new ArrayList();
            //Abrir o arquivo
            FileReader fr = new FileReader(ReceitasTxt);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while((linha = br.readLine())!=null){
                Receitas aux = new Receitas();
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                String conta = vetorString[4];
                String cartao = vetorString[5];
                
                aux.setId(identificador);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setConta(conta);
                aux.setCartao(cartao);
                arrayDasReceitas.add(aux);
            }
            br.close();
            return arrayDasReceitas;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public static void listarComboBoxDescricaoReceita(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Receitas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                String descricao = vetorString[1];

                arr.add(descricao);
            }
            Set<String> set = new HashSet<>(arr);
            arr.clear();
            arr.addAll(set);
            br.close();
            Collections.sort(arr);

            combo.setModel(new DefaultComboBoxModel<String>(arr.toArray(new String[0])));

        } catch (Exception erro) {
            throw erro;
        }

    }
    
    public Receitas retornaReceita(int id) throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = null;
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Receitas.txt");
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Receitas aux = new Receitas();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                if (Integer.parseInt(vetorString[0])==id) {
                    aux.setId(id);
                    aux.setDescricao(vetorString[1]);
                    aux.setValor(Double.parseDouble(vetorString[2]));
                    aux.setData(vetorString[3]);                    
                    aux.setCartao(vetorString[4]);
                    aux.setConta(vetorString[5]);
                }
            }
            return aux;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }
    
}
