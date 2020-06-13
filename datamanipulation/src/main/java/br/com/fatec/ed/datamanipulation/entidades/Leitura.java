package br.com.fatec.ed.datamanipulation.entidades;

public class Leitura {
	
	private Leitor leitor;
	private Livro livro;
	private String status;
	private Meta meta;
	
	
	public Leitura() {
	
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
}
