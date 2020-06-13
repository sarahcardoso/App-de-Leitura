package br.com.fatec.ed.datamanipulation.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.ed.datamanipulation.entidades.Leitor;

public class LeitorController {

	static int id = 1;
	static String caminho = "C:\\Users\\sarah\\Desktop\\leitor.txt";
	public static void main(String[] args) throws IOException {

//		criarArquivo("C:\\Users\\T721371\\Desktop\\FATEC\\ESTRUTURA_DE_DADOS", "leitor");
//		lerArquivo("C:\\Users\\T721371\\Desktop\\FATEC\\ESTRUTURA_DE_DADOS\\leitor.txt");
		criarArquivo("C:\\Users\\sarah\\Desktop\\jow", "leitor");
		lerArquivo("C:\\Users\\sarah\\Desktop\\jow\\leitor.txt");
		
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
			
			while (linha.equals("id:" + id)) {
				System.out.println(linha);
				linha = buffer.readLine();
				linha2 = linha;
				String[] linhas = linha.split("\n");
			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
		if(linha2 == null) {
			return "linha não encontrada.";
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
		List<Leitor> leitores = new ArrayList<Leitor>();

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
		List<Leitor> leitores = new ArrayList<Leitor>();
		Leitor leitor = new Leitor();
		
		try {
			//testar
			String oldLine = lerArquivoAtualizar(caminho, id);
			String newLine = "";
		for (int i = 0; i < leitores.size(); i++) {
			if (leitores.get(i).getId() == id) {
				switch (opcao) {
				case 1:
					leitor.setGenero(alteracao);
					newLine = leitor.toString();
					OverwriteLine(oldLine, newLine);
					break;

				case 2:
					leitor.setNome(alteracao);
					newLine = leitor.toString();
					OverwriteLine(oldLine, newLine);
					break;

				case 3:
					leitor.setIdade(Integer.parseInt(alteracao));
					newLine = leitor.toString();
					OverwriteLine(oldLine, newLine);
					break;

				default:
					break;
				}
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void OverwriteLine(String oldLine, String newLine) throws IOException {
		File arquivo = new File(caminho);
		StringBuffer buffer = new StringBuffer();
	    String fileContents = buffer.toString();
	
	    System.out.println("antes de alterar: " + oldLine);
	    fileContents = fileContents.replace(oldLine, newLine);
	
	    FileWriter writer = new FileWriter(arquivo);
	    System.out.println("");
	    System.out.println("depois de alterar: "+ fileContents);
	    
	    writer.append(fileContents);
	    writer.flush();
	    writer.close();
		}

}
