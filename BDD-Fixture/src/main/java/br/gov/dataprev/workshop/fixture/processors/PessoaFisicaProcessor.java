package br.gov.dataprev.workshop.fixture.processors;

import br.com.six2six.fixturefactory.processor.Processor;
import br.gov.dataprev.workshop.modelo.Documento;
import br.gov.dataprev.workshop.modelo.PessoaFisica;

public class PessoaFisicaProcessor implements Processor {

	public void execute(Object result) {
		if (result instanceof PessoaFisica) {
			
			PessoaFisica pessoa = (PessoaFisica) result;
			
			if (!validaNit(pessoa.getNit())) {
				try {
					throw new Exception("Exceção da PF!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean validaNit(Documento nit) {
		//TODO Pode ser feita uma lógica de validação.
		return true;
	}

}
