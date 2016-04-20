package br.gov.dataprev.workshop.bdd;

import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.com.six2six.fixturefactory.Fixture;
import br.gov.dataprev.workshop.modelo.Documento;
import br.gov.dataprev.workshop.modelo.PessoaFisica;
import br.gov.dataprev.workshop.modelo.Remuneracao;
import br.gov.dataprev.workshop.negocio.RegraPessoaFisica;

public class PessoaSteps {
	
	private PessoaFisica pessoa;
	private RegraPessoaFisica regra = new RegraPessoaFisica();
	
	@Given("uma pessoa física é criada")
	@Aliases(values={"uma pessoa física é instanciada"})
	public void pessoaCriada(){
		pessoa = new PessoaFisica();
	}
	
	@When("eu associo a esta pessoa o nit $nit, cpf $cpf e $numRemun remunerações")
	public void associacaoPessoa(String nit, String cpf, int numRemun){
		Documento nitDoc = new Documento(nit, "teste");
		Documento cpfDoc = new Documento(cpf, "teste");
		
		List<Remuneracao> remuneracoes = Fixture.from(Remuneracao.class).gimme(numRemun, "remuneracaoValida");
		
		pessoa.setNit(nitDoc);
		pessoa.setCpf(cpfDoc);
		pessoa.addRemuneracoes(remuneracoes);
	}
	
	@Then("a pessoa deve ser apta ( $apta )")
	public void pessoaDeveSerApta(boolean apta){
		Assert.assertEquals(regra.isPessoaApta(pessoa), apta);
	}
	
}
