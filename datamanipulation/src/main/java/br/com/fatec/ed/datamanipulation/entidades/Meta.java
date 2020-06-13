package br.com.fatec.ed.datamanipulation.entidades;

import br.com.fatec.ed.datamanipulation.enumerators.TipoMeta;

public class Meta {
	
	private String quantidadePaginas;
	private TipoMeta tipo;
	private Livro livro;

	public Meta() {
	}


	public String getQuantidadePaginas() {
		return quantidadePaginas;
	}


	public void setQuantidadePaginas(String quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}


	public TipoMeta getTipo() {
		return tipo;
	}


	public void setTipo(TipoMeta tipo) {
		this.tipo = tipo;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
