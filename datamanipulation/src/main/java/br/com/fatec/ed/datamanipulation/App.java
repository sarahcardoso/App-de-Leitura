package br.com.fatec.ed.datamanipulation;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.fatec.ed.datamanipulation.application.LeitorController;
import br.com.fatec.ed.datamanipulation.application.LeituraController;
import br.com.fatec.ed.datamanipulation.application.LivroController;

public class App {
	static int id = 0;
	static LeituraController leituraC = new LeituraController();
	static LivroController livroC = new LivroController();
	static LeitorController leitorC = new LeitorController();

	public static void main(String[] args) {

		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"" + "APP LEITURA\n" + " 1 -  LEITURA\n" + " 2 - LIVRO\n" + " 3 - LEITOR\n" + " 9 - SAIR\n"));
			switch (opc) {
			case 1:
				manipulaLeitura();
				break;
			case 2:
				manipulaLivro();
				break;
			case 3:
				manipulaLeitor();
				break;
			// principal
			case 9:
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "VOCÊ DIGITOU UM COMANDO INVÁLIDO");
				break;
			}

		}

	}

	private static void manipulaLivro() {

		int opc2 = 0;

		while (opc2 != 9) {
			opc2 = Integer.parseInt(JOptionPane.showInputDialog("" + "LIVRO\n" + " 1 - LER ARQUIVO LIVRO\n"
					+ " 2 - ORDENAÇÃO INSERTION SORT\n" + " 3 - ORDENAÇÃO BUBBLE SORT\n" + " 9 - VOLTAR\n"));
			switch (opc2) {

			case 1:
				try {
					livroC.lerArquivoLivro("C:\\Users\\sarah\\Desktop\\ed\\livros_entrada.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:

				try {
					livroC.insertionSort();
					livroC.ordenarArquivo("C:\\Users\\sarah\\Desktop\\ed", "insertionsort");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					livroC.bubbleSort();
					livroC.ordenarArquivo("C:\\Users\\sarah\\Desktop\\ed", "bubblensort");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 9:

				break;

			default:
				JOptionPane.showMessageDialog(null, "VOCÊ DIGITOU UM COMANDO INVÁLIDO");
				break;

			}
		}

	}

	public static void manipulaLeitor() {
		int opc3 = 0;

		while (opc3 != 9) {
			opc3 = Integer.parseInt(JOptionPane.showInputDialog("" + "LEITOR\n" + " 1 - CRIAR ARQUIVO\n"
					+ " 2 - LER LEITOR\n" + " 3 - ATUALIZAR LEITOR\n" + " 4 - EXCLUIR LEITOR\n" + "9 - VOLTAR\n"));

			switch (opc3) {

			case 1:
				try {
					leitorC.criarArquivo("C:\\Users\\sarah\\Desktop\\ed", "leitor");
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			case 2:
				try {
					leitorC.lerArquivo("C:\\Users\\sarah\\Desktop\\ed\\leitor.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				alteraLeitor();
				break;
			case 4:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do leitor que você deseja alterar"));
				if (id <= 3) {
					leitorC.excluirLeitor(id);
				} else {
					JOptionPane.showMessageDialog(null, "ID inválido");
					id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do leitor que você deseja alterar"));
				}
				break;
			case 9:
				break;

			default:
				JOptionPane.showMessageDialog(null, "VOCÊ DIGITOU UM COMANDO INVÁLIDO");
				break;

			}
		}

	}

	private static void alteraLeitor() {
		id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do leitor que você deseja alterar"));
		if (id <= 3) {
			int alt = 0;
			while (alt != 9) {
				alt = Integer.parseInt(JOptionPane.showInputDialog("DIGITE PARA ALTERAR\n 1 - ALTERAR GENERO\n "
						+ "2  -ALTERAR NOME\n" + "3 - ALTERAR IDADE\n" + "9 - VOLTAR"));

				switch (alt) {
				case 1:
					String genero = JOptionPane.showInputDialog("INSIRA O GENERO: ");
					leitorC.atualizarLeitor(id, alt, genero);
					break;
				case 2:
					String nome = JOptionPane.showInputDialog("INSIRA O NOME: ");
					leitorC.atualizarLeitor(id, alt, nome);
					break;
				case 3:
					String idade = JOptionPane.showInputDialog("INSIRA O IDADE: ");
					leitorC.atualizarLeitor(id, alt, idade);
					break;
				case 9:
					break;
				default:
					JOptionPane.showMessageDialog(null, "VOCÊ DIGITOU UM COMANDO INVÁLIDO");
					break;

				}

			}

		}

		else {
			JOptionPane.showMessageDialog(null, "ID inválido");
			id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do leitor que você deseja alterar"));

		}

	}

	public static void manipulaLeitura() {
		int opc1 = 0;
		while (opc1 != 9) {
			opc1 = Integer.parseInt(JOptionPane.showInputDialog("" + "LEITURA\n" + " 1 - CRIAR ARQUIVO\n"
					+ "2 - LER ARQUIVO\n" + " 3 - PERSONALIZAR LEITURA\n" + " 4 - EXCLUIR\n" + " 9 - SAIR\n"));

			switch (opc1) {

			case 1:
				try {
					leituraC.criarArquivo("C:\\Users\\sarah\\Desktop\\ed", "leitura");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					leituraC.lerArquivo("C:\\Users\\sarah\\Desktop\\ed\\leitura.txt");
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da leitura que você quer alterar"));
				String status = JOptionPane.showInputDialog(
						"COLOQUE OS STATUS DE LEITURA\n" + "L - LIDO \n" + "Q - QUERO LER\n" + "LE -LENDO\n");
				try {
					leituraC.personalizarLeitura(id, status);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da leitura que você quer excluir"));
				leituraC.excluirLeitura(id);
			case 9:

				break;

			default:
				JOptionPane.showMessageDialog(null, "VOCÊ DIGITOU UM COMANDO INVÁLIDO");
				break;

			}

		}

	}
}
