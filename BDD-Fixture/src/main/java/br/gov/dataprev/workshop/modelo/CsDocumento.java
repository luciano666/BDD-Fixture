package br.gov.dataprev.workshop.modelo;

public enum CsDocumento {
	
	CPF( (byte) 1, "CPF"), NIT( (byte) 2, "NIT"), RG( (byte) 3, "Registro Geral");
	
	private final Byte codigo;
	private final String descricao;
	
	private CsDocumento(Byte codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Byte getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CsDocumento valueOf(Long codigo) {
		for (CsDocumento tipo : values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
