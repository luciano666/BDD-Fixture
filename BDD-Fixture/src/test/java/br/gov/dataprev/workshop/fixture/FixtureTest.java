package br.gov.dataprev.workshop.fixture;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.gov.dataprev.workshop.fixture.processors.PessoaFisicaProcessor;
import br.gov.dataprev.workshop.modelo.PessoaFisica;
import br.gov.dataprev.workshop.modelo.Remuneracao;
import br.gov.dataprev.workshop.negocio.IRegraGeral;
import br.gov.dataprev.workshop.negocio.RegraPessoaFisica;

public class FixtureTest {
	
	private IRegraGeral regraPessoa;
	
	@Before
	public void setUp(){
		regraPessoa = new RegraPessoaFisica();
		FixtureFactoryLoader.loadTemplates("br.gov.dataprev.workshop.fixture.templates");
	}

	@Test
	public void testPessoaFisicaApta20Remun(){
		PessoaFisica pessoa = getPessoaComRemuneracoes(20);
		
		Assert.assertTrue( regraPessoa.isPessoaApta(pessoa) );
	}


	@Test
	public void testPessoaFisicaAptaMaior20Remun(){
		PessoaFisica pessoa = getPessoaComRemuneracoes(21);
		
		Assert.assertTrue( regraPessoa.isPessoaApta(pessoa) );
	}
	
	@Test
	public void testPessoaFisicaInaptaRemun(){
		PessoaFisica pessoa = getPessoaComRemuneracoes(19);
		
		Assert.assertFalse( regraPessoa.isPessoaApta(pessoa) );
	}
	
	@Test
	public void testPessoaFisicaInaptaCpf(){
		PessoaFisica pessoa = Fixture.from(PessoaFisica.class).gimme("pessoaSemCpf");
		
		Assert.assertFalse( regraPessoa.isPessoaApta(pessoa) );
	}
	
	@Test
	public void testPessoaFisicaInaptaNit(){
		PessoaFisica pessoa = Fixture.from(PessoaFisica.class).uses(new PessoaFisicaProcessor()).gimme("pessoaSemNit");
		
		Assert.assertFalse( regraPessoa.isPessoaApta(pessoa) );
	}
	
	private PessoaFisica getPessoaComRemuneracoes(int quantidadeRemun) {
		
		PessoaFisica pessoa = Fixture.from(PessoaFisica.class).gimme("pessoa");
		
		List<Remuneracao> remuneracoes = Fixture.from(Remuneracao.class).gimme(quantidadeRemun, "remuneracaoValida");
		
		pessoa.addRemuneracoes( remuneracoes );
		
		return pessoa;
	}
}
