package br.gov.dataprev.workshop.modelo;

import java.util.Date;

public class Documento {
	
	public String numero;
	public String descricao;
	public Date dataProcessamento;
	
	public Documento() {
		this.dataProcessamento = new Date();
	}
	
	public Documento(String numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
		this.dataProcessamento = new Date();
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataProcessamento == null) ? 0 : dataProcessamento
						.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (dataProcessamento == null) {
			if (other.dataProcessamento != null)
				return false;
		} else if (!dataProcessamento.equals(other.dataProcessamento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.numero;
	}
}
