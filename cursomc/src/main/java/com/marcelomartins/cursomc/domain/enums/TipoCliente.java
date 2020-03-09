package com.marcelomartins.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if(cod.equals(tipoCliente.getCodigo())) {
				return tipoCliente;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
