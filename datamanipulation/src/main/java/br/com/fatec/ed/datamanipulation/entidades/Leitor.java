package br.com.fatec.ed.datamanipulation.entidades;

public class Leitor {

	private int id;
	private String nome;
	private int idade;
	private String genero;

	public Leitor() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[genero: " + this.genero + " , " + " nome: " + this.nome + " , " + " idade: " + this.idade + " , " + " id: "  + this.id + "]";
	}
}
