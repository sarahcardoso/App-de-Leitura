package br.com.fatec.ed.datamanipulation.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LivroController {
	public static void main(String[] args) throws IOException {
		lerArquivoLivro("C:\\Users\\T-Gamer\\Documents\\novoo\\livro.txt");
	}
	public static void lerArquivoLivro(String absolutePath) throws IOException {
        File arquivo = new File(absolutePath);

        if (arquivo.exists()) {

            FileInputStream fluxo = new FileInputStream(arquivo);
            InputStreamReader livro = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(livro);
            String linha = buffer.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = buffer.readLine();
            }

            buffer.close();
            livro.close();
            fluxo.close();
        } else {
            throw new IOException("Arquivo não existe");
        }
    }

}
