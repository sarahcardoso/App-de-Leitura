package br.com.fatec.ed.datamanipulation.application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.ed.datamanipulation.entidades.Leitor;

public class LeitorController {

    //TODO: ALTERAR O CAMINHO 
    static int id = 1;
    static String caminho = "C:\\Users\\Lenovo\\Documents\\vitoria_temp\\leitor.txt";
    static List<Leitor> leitores = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        criarArquivo("C:\\Users\\Lenovo\\Documents\\vitoria_temp", "leitor");
//        lerArquivo("C:\\Users\\Lenovo\\Documents\\vitoria_temp\\leitor.txt");

        atualizarLeitor(2, 2, "VIADNHO");

    }

    public static void criarArquivo(String path, String arq) throws IOException {

        File dir = new File(path);
        File arquivo = new File(path, arq + ".txt");
        if (dir.exists()) {
            boolean arquivoExiste = false;
            if (arquivo.exists()) {
                arquivoExiste = true;
            }
            String conteudo = gerarArquivoLeitor();
            FileWriter fw = new FileWriter(arquivo, arquivoExiste);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(conteudo);
            pw.flush();
            pw.close();
            fw.close();
        } else {
            throw new IOException("Diretório Inválido");
        }
    }

    public static void lerArquivo(String absolutePath) throws IOException {
        File arquivo = new File(absolutePath);

        if (arquivo.exists()) {

            FileInputStream fluxo = new FileInputStream(arquivo);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = buffer.readLine();
            }

            buffer.close();
            leitor.close();
            fluxo.close();
        } else {
            throw new IOException("Arquivo não existe");
        }
    }

    public static String lerArquivoAtualizar(String absolutePath, int id) throws IOException {
        File arquivo = new File(absolutePath);

        String linha2 = "";
        if (arquivo.exists()) {

            FileInputStream fluxo = new FileInputStream(arquivo);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {
                if (linha.contains(", id: " + id)) {
                    System.out.println(linha);
                    linha2 = linha;
                }
                linha = buffer.readLine();

            }

            buffer.close();
            leitor.close();
            fluxo.close();
        } else {
            throw new IOException("Arquivo inválido");
        }
        return linha2;
    }

    public static String gerarArquivoLeitor() {
        StringBuffer buffer = new StringBuffer();
        String linha = "";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= 1; i++) {

            System.out.println("INSIRA O NOME DO LEITOR: ");
            String nome = sc.next();

            System.out.println("INSIRA O GENERO: ");
            String genero = sc.next();

            System.out.println("INSIRA A IDADE: ");
            int idade = sc.nextInt();

            linha = alimentarListaLeitor(nome, genero, idade);
            buffer.append(linha + "\r\n");

        }

        sc.close();
        return buffer.toString();
    }

    public static String alimentarListaLeitor(String nome, String genero, int idade) {

        Leitor leitor = new Leitor();
        leitor.setId(id++);
        leitor.setGenero(genero);
        leitor.setIdade(idade);
        leitor.setNome(nome);
        leitores.add(leitor);

        String resposta = leitor.toString();

        return resposta;
    }

    public static void atualizarLeitor(int id, int opcao, String alteracao) {

        Leitor leitor = new Leitor();

        try {
            // testar
            String oldLine = lerArquivoAtualizar(caminho, id);

            for (int i = 0; i < leitores.size(); i++) {


                if (leitores.get(i).getId() == id) {
                    switch (opcao) {
                        case 1:
                            leitores.get(i).setGenero(alteracao);

                            String newLine = leitores.get(i).toString();
                            OverwriteLine(oldLine, newLine);
                            break;

                        case 2:
                            leitores.get(i).setNome(alteracao);

                            newLine = leitores.get(i).toString();
                            OverwriteLine(oldLine, newLine);
                            break;

                        case 3:
                            leitores.get(i).setIdade(Integer.parseInt(alteracao));
                            newLine = leitores.get(i).toString();
                            OverwriteLine(oldLine, newLine);
                            break;

                        default:
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    public static void OverwriteLine(String oldLine, String newLine) throws IOException {
        String filePath = "C:\\Users\\Lenovo\\Documents\\vitoria_temp\\leitor.txt";
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("antes de alterar: " + fileContents);

        sc.close();


        fileContents = fileContents.replace(oldLine, newLine);

        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("depois de alterar: " + fileContents);

        writer.append(fileContents);
        writer.flush();
        writer.close();
    }

}

