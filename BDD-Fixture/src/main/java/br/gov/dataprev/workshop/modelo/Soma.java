package br.gov.dataprev.workshop.modelo;

public class Soma {
	
	private int resultado;
	
	public void soma(int a, int b){
		resultado = a + b;
	}

	public int getResultado(){
		return resultado;
	}
}
