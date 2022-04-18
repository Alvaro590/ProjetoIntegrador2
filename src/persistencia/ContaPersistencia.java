/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import modelos.entidades.Conta;
import modelos.interfaces.IConta;

/**
 *
 * @author Sciencegamer
 */
public class ContaPersistencia implements IConta {

    private String nomeDoArquivoDadosNoDisco = "C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt";

    //Metodos
    public ContaPersistencia(String nomeDoArquivoDadosNoDisco) {
        this.nomeDoArquivoDadosNoDisco = nomeDoArquivoDadosNoDisco;
    }

    @Override
    public void incluir(Conta objeto) throws Exception {
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
    public void alterar(int id, Conta objeto) throws Exception {
        try {
            apagar(id);
            incluir(objeto);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void apagar(int id) throws Exception {
        try {
            ArrayList<Conta> arr = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for (int pos = 0; pos < arr.size(); pos++) {
                if (id != arr.get(pos).getId()) {
                    bw.write(arr.get(pos).toString() + "\n");
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void alterarSaldo(int id, double valor) throws Exception {
        try {
            ArrayList<Conta> arr = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for (int pos = 0; pos < arr.size(); pos++) {
                if (id != arr.get(pos).getId()) {
                    bw.write(arr.get(pos).toString() + "\n");
                } else {
                    if (pos != 1) {
                        bw.write(arr.get(pos).toString() + "\n");
                    } else {                        
                        String aux1 = voltaSaldo(id);
                        aux1+=valor;
                        bw.write(aux1 + "\n");
                    }
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    public String voltaSaldo(int id) throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = "";
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Conta aux = new Conta();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                if (vetorString[0].equals(aux1)) {
                    aux2 = vetorString[1];
                }
            }

            return aux2;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }

    public String voltaLimite(int id) throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = "";
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Conta aux = new Conta();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                if (vetorString[0].equals(aux1)) {
                    aux2 = vetorString[3];
                }
            }

            return aux2;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }

    @Override
    public Conta consultar(int id) throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Conta aux = new Conta();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                double saldo = Double.parseDouble(vetorString[1]);
                String banco = vetorString[2];
                double limite = Double.parseDouble(vetorString[3]);
                double taxa = Double.parseDouble(vetorString[4]);

                aux.setId(identificador);
                aux.setSaldo(saldo);
                aux.setBanco(banco);
                aux.setLimite(limite);
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
    public ArrayList<Conta> listagem() throws Exception {
        try {
            ArrayList<Conta> arrayConta = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Conta aux = new Conta();
                String vetorString[] = linha.split(";");

                int identificador = Integer.parseInt(vetorString[0]);
                double saldo = Double.parseDouble(vetorString[1]);
                String banco = vetorString[2];
                double limite = Double.parseDouble(vetorString[3]);
                double taxa = Double.parseDouble(vetorString[4]);

                aux.setId(identificador);
                aux.setSaldo(saldo);
                aux.setBanco(banco);
                aux.setLimite(limite);
                aux.setTaxa(taxa);
                arrayConta.add(aux);
            }
            br.close();
            return arrayConta;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public Conta retornaConta(int id) throws Exception {
        try {
            String aux1= id+"";            
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Conta aux = new Conta();
                String vetorString[] = linha.split(";");
                if(aux1.equals(vetorString[0])){
                    int identificador = Integer.parseInt(vetorString[0]);
                    double saldo = Double.parseDouble(vetorString[1]);
                    String banco = vetorString[2];
                    double limite = Double.parseDouble(vetorString[3]);
                    double taxa = Double.parseDouble(vetorString[4]);

                    aux.setId(identificador);
                    aux.setSaldo(saldo);
                    aux.setBanco(banco);
                    aux.setLimite(limite);
                    aux.setTaxa(taxa);
                    return aux;
                }            
                
            }            
            br.close();
            return null;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public static void listarComboBoxConta(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Bancos.txt");
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

}
