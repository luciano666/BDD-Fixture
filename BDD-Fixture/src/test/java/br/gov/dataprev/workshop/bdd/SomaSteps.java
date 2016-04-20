package br.gov.dataprev.workshop.bdd;

import junit.framework.Assert;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.dataprev.workshop.modelo.Soma;

public class SomaSteps {
	
	private Soma soma;
	
	@Given("um somador é criado")
	@Aliases(values={"um somador é instanciado"})
	public void somaCriada(){
		soma = new Soma();
	}
	
	@When("eu adiciono $a e $b")
	public void somaExecutada(int a, int b){
		soma.soma(a, b);
	}
	
	@Then("o resultado deve ser $c")
	public void resultadoDeveSer(int c){
		Assert.assertEquals(soma.getResultado(), c);;
	}
	
}
