package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)

@CucumberOptions(

    features = "src/spec/features",
   glue = {"login","Utils","logout","commandeValider","addgreencard","commande","commandeRejeter","commandeRenvoyer"},
    
    plugin = {

        "pretty",
        "html:target/cucumber-report.html"
        	

    },
    tags =  ("@commande") ,

    monochrome = true,

    publish = true

)

public class TestRunner {

}