package br.gov.dataprev.workshop.modelo;

import java.util.Date;

public class Remuneracao {

	private Double valor;
	private Date dataRemuneracao;
	private String observacao;
	
	public Remuneracao() {
		dataRemuneracao = new Date();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataRemuneracao() {
		return dataRemuneracao;
	}

	public void setDataRemuneracao(Date dataRemuneracao) {
		this.dataRemuneracao = dataRemuneracao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataRemuneracao == null) ? 0 : dataRemuneracao.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Remuneracao other = (Remuneracao) obj;
		if (dataRemuneracao == null) {
			if (other.dataRemuneracao != null)
				return false;
		} else if (!dataRemuneracao.equals(other.dataRemuneracao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
