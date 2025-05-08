package commandeRenvoyer;
import static Utils.DriverManager.getDriver;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class CommandeRenvoyerStepDef {

	private WebDriver driver;

	private CommandeRenvoyerPageObject commanderenvoyerpageobject;

	


	@When("I open the list of available orders R")
	public void Je_clique_sur_commandes_Assurances() {
		driver = getDriver();
		commanderenvoyerpageobject=PageFactory.initElements(driver,CommandeRenvoyerPageObject.class);


		commanderenvoyerpageobject.pageCommande();
	   
	}
	@When("I select an order to process R")
	public void Je_sélectionne_une_commande_qui_je_veux_la_renvoyer() {
		commanderenvoyerpageobject.selectionneCommande();
	}
	@When("I click on resend")
	public void je_clique_sur_renvoyer() {
		commanderenvoyerpageobject.renvoyerCommande();
	}
	@Then("A confirmation message is display R")
	public void Un_message_de_renvoyer_avec_sucées_s_affiche() {
		commanderenvoyerpageobject.verifyRenvoyerCommandeSucced();
	}



	

}