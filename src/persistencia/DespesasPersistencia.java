/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelos.entidades.Despesas;
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
import javax.swing.JOptionPane;
import modelos.interfaces.IDespesas;

public class DespesasPersistencia implements IDespesas {

    private String DespesasTxt = "";

    //Construtor
    public DespesasPersistencia(String DespesasTxt) {
        this.DespesasTxt = DespesasTxt;
    }

    @Override
    public void incluir(Despesas objeto) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(DespesasTxt, true);
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
    public void alterar(Despesas objeto) throws Exception {
        try {
            excluir(objeto.getId());
            incluir(objeto);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Despesas> array = listagem();
            //Criar o arquivo
            FileWriter fw = new FileWriter(DespesasTxt);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            for (int pos = 0; pos < array.size(); pos++) {
                if (id != array.get(pos).getId()) {
                    bw.write(array.get(pos).toString() + "\n");
                }
            }
            //fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Despesas consultar(int id) throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(DespesasTxt);
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Despesas aux = new Despesas();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");

                int identidade = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                String cartao = vetorString[4];
                String fixa = vetorString[5];
                int parcelas = Integer.parseInt(vetorString[6]);
                String conta = vetorString[7];

                aux.setId(identidade);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setCartao(cartao);
                aux.setFixa(fixa);
                aux.setParcelas(parcelas);
                aux.setConta(conta);

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
    public ArrayList<Despesas> listagem() throws Exception {
        try {
            ArrayList<Despesas> arrayDasDespesas = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader(DespesasTxt);
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Despesas aux = new Despesas();
                String vetorString[] = linha.split(";");

                int id = Integer.parseInt(vetorString[0]);
                String descricao = vetorString[1];
                double valor = Double.parseDouble(vetorString[2]);
                String data = vetorString[3];
                String cartao = vetorString[4];
                String fixa = vetorString[5];
                int parcelas = Integer.parseInt(vetorString[6]);
                String conta = vetorString[7];

                aux.setId(id);
                aux.setDescricao(descricao);
                aux.setValor(valor);
                aux.setData(data);
                aux.setCartao(cartao);
                aux.setFixa(fixa);
                aux.setParcelas(parcelas);
                aux.setConta(conta);
                arrayDasDespesas.add(aux);
            }
            br.close();
            return arrayDasDespesas;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public String retornaAtributoDespesa(int id, int atributo) throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = null;
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Despesas aux = new Despesas();
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

    public Despesas retornaDespesa(int id) throws Exception {
        BufferedReader br = null;
        try {
            String aux1 = id + "";
            String aux2 = null;
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
            //Criar o buffer do arquivo
            br = new BufferedReader(fr);
            String linha = "";
            Despesas aux = new Despesas();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                if (Integer.parseInt(vetorString[0])==id) {
                    aux.setId(id);
                    aux.setDescricao(vetorString[1]);
                    aux.setValor(Double.parseDouble(vetorString[2]));
                    aux.setData(vetorString[3]);
                    aux.setParcelas(Integer.parseInt(vetorString[4]));
                    aux.setFixa(vetorString[5]);
                    aux.setCartao(vetorString[6]);
                    aux.setConta(vetorString[7]);
                }
            }
            return aux;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }

    }

    public static void listarComboBoxDespesa(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");
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

    public static void listarComboBoxDespesa2(JComboBox combo) throws Exception {
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

    public static void listarComboBoxDespesa3(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Cartoes.txt");
            //Criar o buffer do arquivo
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");

                if (!vetorString[8].equals("0.0")) {
                    String id = vetorString[0];
                    arr.add(id);
                }

            }
            br.close();
            Collections.sort(arr);

            combo.setModel(new DefaultComboBoxModel<String>(arr.toArray(new String[0])));

        } catch (Exception erro) {
            throw erro;
        }

    }

    public static void listarComboBoxDescricaoDespesa(JComboBox combo) throws Exception {
        try {
            ArrayList<String> arr = new ArrayList<>();
            //Abrir o arquivo
            FileReader fr = new FileReader("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");
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

}
