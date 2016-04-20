package br.gov.dataprev.workshop.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.function.impl.CpfFunction;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.gov.dataprev.workshop.modelo.CsDocumento;
import br.gov.dataprev.workshop.modelo.Documento;
import br.gov.dataprev.workshop.modelo.PessoaFisica;
import br.gov.dataprev.workshop.modelo.Remuneracao;

public class PessoaFisicaTemplate implements TemplateLoader {

	public void load() {
		
		Fixture.of(PessoaFisica.class).addTemplate("pessoa", new Rule(){{
			add("nome", firstName());
			add("dataNascimento", instant("20 years before"));
			add("cpf", one(Documento.class, "cpfValido"));
			add("nit", one(Documento.class, "nitValido"));
//			add("remuneracoes", has(20).of(Remuneracao.class, "remuneracaoValida"));
		}});
		
		Fixture.of(PessoaFisica.class).addTemplate("pessoaSemCpf", new Rule(){{
			add("nome", firstName());
			add("dataNascimento", instant("20 years before"));
			add("nit", one(Documento.class, "nitValido"));
		}});
		
		Fixture.of(PessoaFisica.class).addTemplate("pessoaSemNit", new Rule(){{
			add("nome", firstName());
			add("dataNascimento", instant("20 years before"));
			add("cpf", one(Documento.class, "cpfValido"));
		}});
		
		Fixture.of(Documento.class).addTemplate("cpfValido", new Rule(){{
			add("numero", new CpfFunction(true));
			add("descricao", CsDocumento.CPF.getDescricao());
			add("dataProcessamento", instant("now"));
		}});
		
		Fixture.of(Documento.class).addTemplate("nitValido", new Rule(){{
			add("numero", PessoaFisica.geraNIT(true));
			add("descricao", CsDocumento.NIT.getDescricao());
			add("dataProcessamento", instant("now"));
		}});
		
		Fixture.of(Remuneracao.class).addTemplate("remuneracaoValida", new Rule(){{
			add("valor", random(Double.class, range(1000, 8000)));
			add("dataRemuneracao", instant("now"));
			add("observacao", regex("\\w{15}-\\d{2}") );
		}});
		
	}
}
