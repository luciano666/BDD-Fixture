package br.gov.dataprev.workshop.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaFisica {
	
	private String nome;
	private Date dataNascimento;
	private Documento cpf;
	private Documento nit;
	private Documento rg;
	private Endereco endereco;
	private List<Remuneracao> remuneracoes;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Documento getCpf() {
		return cpf;
	}
	
	public void setCpf(Documento cpf) {
		this.cpf = cpf;
	}
	
	public Documento getNit() {
		return nit;
	}
	
	public void setNit(Documento nit) {
		this.nit = nit;
	}
	
	public Documento getRg() {
		return rg;
	}
	
	public void setRg(Documento rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Remuneracao> getRemuneracoes() {
		return remuneracoes;
	}

	public void setRemuneracoes(List<Remuneracao> remuneracoes) {
		this.remuneracoes = remuneracoes;
	}
	
	public void addRemuneracao(Remuneracao remuneracao){
		if (remuneracao != null) {
			if (this.remuneracoes == null) {
				this.remuneracoes = new ArrayList<Remuneracao>();
			}
			this.remuneracoes.add(remuneracao);
		}
	}

	public void addRemuneracoes(List<Remuneracao> remuneracoes){
		if (remuneracoes != null) {
			if (this.remuneracoes == null) {
				this.remuneracoes = new ArrayList<Remuneracao>();
			}
			this.remuneracoes.addAll(remuneracoes);
		}
	}
	
	public void removeRemuneracao(Remuneracao remuneracao){
		if (this.remuneracoes != null && remuneracao != null) {
			if (this.remuneracoes.contains(remuneracao)) {
				this.remuneracoes.remove(remuneracao);
			}
		}
	}
	
	public static int geraRandom(int n) {
	    int ranNum = (int) Math.round(Math.random()*n);
	    return ranNum;
	}
	
	public static String geraNIT(boolean formatted){
		int n = 9;
		int n1  = 1;
	 	int n2  = geraRandom(n);
	 	int n3  = geraRandom(n);
	 	int n4  = geraRandom(n);
	 	int n5  = geraRandom(n);
	 	int n6  = geraRandom(n);
	 	int n7  = geraRandom(n);
	 	int n8  = geraRandom(n);
	 	int n9  = geraRandom(n);
	 	int n10 = geraRandom(n);

		int d1 =  n1*3 + n2*2 + n3*9 + n4*8 + n5*7 + n6*6 + n7*5 + n8*4 + n9*3 + n10*2;
	 	d1 = 11 -  (d1 % 11) ;
	 	if (d1>=10) d1 = 0;

		if (formatted)
			return ""+n1+"."+n2+n3+n4+"."+n5+n6+n7+"."+n8+n9+n10+"-"+d1;
		else
			return ""+n1+n2+n3+n4+n5+n6+n7+n8+n9+n10+d1;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nit == null) ? 0 : nit.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nit == null) {
			if (other.nit != null)
				return false;
		} else if (!nit.equals(other.nit))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nData Nasc.: " + this.dataNascimento + "\nCPF: " + this.cpf + "\nNit: " + this.nit;
	}
}
