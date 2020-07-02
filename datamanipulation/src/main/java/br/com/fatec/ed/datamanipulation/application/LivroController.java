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

import org.apache.log4j.Logger;

import br.com.fatec.ed.datamanipulation.entidades.Livro;

public class LivroController {
	private static Logger LOGGER = Logger.getLogger(LivroController.class);
	static List<Livro> livros = new ArrayList<>();
	static List<Livro> temp = new ArrayList<>();
	static List<Livro> aux = new ArrayList<>();
	static String caminho = "C:\\Users\\sarah\\Desktop\\ed";

	public static void lerArquivoLivro(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);

		if (arquivo.exists()) {

			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader livro = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(livro);
			String linha = buffer.readLine();

			while (linha != null) {
				// System.out.println(linha);
				gerarLivro(linha);
				linha = buffer.readLine();

			}

			buffer.close();
			livro.close();
			fluxo.close();
		} else {
			LOGGER.error("ARQUIVO NÃO ENCONTRADO");
			throw new IOException("Arquivo não existe");
		}

		LOGGER.info("LIVROS COLHIDOS COM SUCESSO");
	}

	private static void gerarLivro(String linha) {
		// : .*?,

		if (linha != null) {
			Livro livro = new Livro();
			String[] line = linha.split("(?=,).*?(?<=: )");

			for (int i = 0; i < line.length; i++) {
				// System.out.println(line[i] + " " + i);
				if (i == 1)
					livro.setTitulo(line[i].toString());
				if (i == 2)
					livro.setAutor(line[i].toString());
				if (i == 3)
					livro.setGenero(line[i].toString());
				if (i == 4)
					livro.setPaginas(Integer.parseInt(line[i].toString().trim()));

				if (i == 5)
					livro.setISBN(Integer.parseInt(line[i].toString().trim()));
			}

			livros.add(livro);
			aux.add(livro);

		}

	}

	public static void bubbleSort() {

		for (int i = 0; i < livros.size() - 1; i++) {
			for (int j = 0; j < livros.size() - i - 1; j++) {
				temp.add(livros.get(j));

				if (livros.get(j).getPaginas() > livros.get(j + 1).getPaginas()) {
					temp.set(j, livros.get(j));

					livros.set(j, livros.get(j + 1));

					livros.set(j + 1, temp.get(j));

				}
			}
		}

	}

	public static void insertionSort() {

		for (int i = 1; i < livros.size(); i++) {
			aux.set(i, livros.get(i));
			int j = i - 1;
			while (j >= 0 && livros.get(j).getISBN() > aux.get(i).getISBN()) {
				livros.set(j + 1, livros.get(j));
				j = j - 1;
			}
			livros.set(j + 1, aux.get(i));

		}

	}

	public static void ordenarArquivo(String path, String arq) throws IOException {

		File dir = new File(path);
		File arquivo = new File(path, arq + ".txt");
		if (dir.exists()) {
			boolean arquivoExiste = false;
			if (arquivo.exists()) {
				arquivoExiste = true;
			}
			String conteudo = gerarArquivoLivro();
			FileWriter fw = new FileWriter(arquivo, arquivoExiste);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(conteudo);
			pw.flush();
			pw.close();
			fw.close();
		} else {
			throw new IOException("Diretório Inválido");
		}

		LOGGER.info("LIVRO REGISTRADO EM " + arq + " COM SUCESSO");
	}

	public static String gerarArquivoLivro() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		for (int i = 0; i < livros.size(); i++) {
			linha = livros.get(i).toString();
			buffer.append(linha + "\r\n");
		}
		return buffer.toString();
	}

}
