package br.gov.dataprev.workshop.bdd;

import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Before;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class BddTest extends JUnitStory {
	
	@Before
	public void setUp(){
		FixtureFactoryLoader.loadTemplates("br.gov.dataprev.workshop.fixture.templates");
	}
	
	@Override
    public Configuration configuration() {
    	
    	Keywords keywords = new LocalizedKeywords(new Locale("pt"));
    	
        return new MostUsefulConfiguration()
        	.useKeywords(keywords)
        	.useStoryParser(new RegexStoryParser(keywords))
            // Onde procurar pelas estórias
        	.useStoryLoader(new LoadFromClasspath(this.getClass()))
            // Para onde fazer os reports
            .useStoryReporterBuilder(new StoryReporterBuilder()
            								.withDefaultFormats()
            								.withFormats(Format.CONSOLE, Format.HTML)); 
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {        
        // var args, podemos ter mais de uma classe de steps
        return new InstanceStepsFactory(configuration(), new SomaSteps(), new PessoaSteps());
    }
}
