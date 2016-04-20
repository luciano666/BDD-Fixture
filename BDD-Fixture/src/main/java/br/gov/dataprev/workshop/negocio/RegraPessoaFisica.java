package br.gov.dataprev.workshop.negocio;

import br.gov.dataprev.workshop.modelo.PessoaFisica;

/**
 * Regra Geral: 
 * 
 * Para ser APTA, a pessoa física deve ter o documento do tipo cpf válido, o nit preenchido e pelo menos 20 remunerações.
 * 
 * 
 * @author luciano.rocha
 *
 */
public class RegraPessoaFisica implements IRegraGeral {
	
	public boolean isPessoaApta(PessoaFisica pessoa) {
		
		if ( pessoa != null ) {
			boolean cpfValido = pessoa.getCpf() != null && pessoa.getCpf().getNumero().matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
			boolean nitValido = pessoa.getNit() != null && pessoa.getNit().getNumero().matches("\\d{1}.\\d{3}.\\d{3}.\\d{3}-\\d{1}");
			boolean remuneracoesValidas = pessoa.getRemuneracoes() != null && pessoa.getRemuneracoes().size() >= 20;
			
			return cpfValido && nitValido && remuneracoesValidas;
		}
		else {
			return false;
		}
		
	}

}
