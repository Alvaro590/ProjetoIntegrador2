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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelos.entidades.Cartao;

import modelos.interfaces.ICartao;

/**
 *
 * @author Sciencegamer
 */
public class CartaoPersistencia implements ICartao {

    private String nomeDoArquivoDadosNoDisco = "";

    //Metodos
    public CartaoPersistencia(String nomeDoArquivoDadosNoDisco) {
        this.nomeDoArquivoDadosNoDisco = nomeDoArquivoDadosNoDisco;
    }

    @Override
    public void incluir(Cartao objeto) throws Exception {
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
    public void alterar(int id, Cartao objeto) throws Exception {

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
            ArrayList<Cartao> arrayDosCartoes = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for (int pos = 0; pos < arrayDosCartoes.size(); pos++) {
                if (id != arrayDosCartoes.get(pos).getId()) {
                    bw.write(arrayDosCartoes.get(pos).toString() + "\n");
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public Cartao consultarPorId(int id) throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Cartao aux = new Cartao();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                
                int identificador = Integer.parseInt(vetorString[0]);
                String numero = vetorString[1];
                String nome = vetorString[2];
                String validade = vetorString[3];
                int diaDoFechamento = Integer.parseInt(vetorString[4]);
                int diaDoPagamento = Integer.parseInt(vetorString[5]);
                int cvv = Integer.parseInt(vetorString[6]);
                String bandeira = vetorString[7];
                double limite = Double.parseDouble(vetorString[8]);                
                int agencia = Integer.parseInt(vetorString[9]);
                String conta = vetorString[10];
                double taxa = Double.parseDouble(vetorString[11]);  

                aux.setId(identificador);
                aux.setNumero(numero);
                aux.setNome(nome);
                aux.setValidade(validade);
                aux.setDiaDoFechamento(diaDoFechamento);
                aux.setDiaDoPagamento(diaDoPagamento);
                aux.setCvv(cvv);
                aux.setBandeira(bandeira);
                aux.setLimite(limite);
                aux.setAgencia(agencia);
                aux.setConta(conta);
                aux.setTaxa(taxa);
                
                if (aux.getId() == id) {
                    return aux;
                }
            }
            aux = null;
            return aux;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }

    @Override
    public ArrayList<Cartao> listagem() throws Exception {
        try {
            ArrayList<Cartao> arrayDosCartoes = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Cartao aux = new Cartao();
                String vetorString[] = linha.split(";");
                
                int identificador = Integer.parseInt(vetorString[0]);
                String numero = vetorString[1];
                String nome = vetorString[2];
                String validade = vetorString[3];
                int diaDoFechamento = Integer.parseInt(vetorString[4]);
                int diaDoPagamento = Integer.parseInt(vetorString[5]);
                int cvv = Integer.parseInt(vetorString[6]);
                String bandeira = vetorString[7];
                double limite = Double.parseDouble(vetorString[8]);                
                int agencia = Integer.parseInt(vetorString[9]);
                String conta = vetorString[10];
                double taxa = Double.parseDouble(vetorString[11]);  

                aux.setId(identificador);
                aux.setNumero(numero);
                aux.setNome(nome);
                aux.setValidade(validade);
                aux.setDiaDoFechamento(diaDoFechamento);
                aux.setDiaDoPagamento(diaDoPagamento);
                aux.setCvv(cvv);
                aux.setBandeira(bandeira);
                aux.setLimite(limite);
                aux.setAgencia(agencia);
                aux.setConta(conta);
                aux.setTaxa(taxa);

                arrayDosCartoes.add(aux);
            }
            br.close();
            return arrayDosCartoes;
        } catch (Exception erro) {
            throw erro;
        }
    }   


    public static void listarComboBoxCartao(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {

                String vetorString[] = linha.split(";");
                String id = vetorString[0];
                arr.add(id);
            }
            arr.add("0");
            br.close();
            Collections.sort(arr);

            combo.setModel(new DefaultComboBoxModel<String>(arr.toArray(new String[0])));

        } catch (Exception erro) {
            throw erro;
        }

    }
    
    public String retornaAtributoCartao(int id, int atributo)throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = null;
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Cartao aux = new Cartao();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                if (vetorString[0].equals(aux1)) {
                    aux2 = vetorString[atributo];
                }
            }
            return aux2;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }
}

