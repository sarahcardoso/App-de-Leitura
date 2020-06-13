package br.com.fatec.ed.datamanipulation.enumerators;

public enum TipoMeta {
	
	
	MENSAL("M"), 
	DIARIA("D"),
	SEMANAL("S");
	
	private String codigo;
	
	TipoMeta(String codigo) {
		this.codigo = codigo;
	}

}
