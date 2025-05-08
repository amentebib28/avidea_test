package commandeRejeter;
import static Utils.DriverManager.getDriver;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class CommandeRejeterStepDef {

	private WebDriver driver;

	private CommandeRejeterPageObject commanderejeterpageobject;

	


	@When("I open the list of available orders Rej")
	public void J_clique_sur_commandes_Assurances() {
		driver = getDriver();
		commanderejeterpageobject=PageFactory.initElements(driver,CommandeRejeterPageObject.class);


		commanderejeterpageobject.pageCommande();
	   
	}
	@When("I select an order to process Rej")
	public void Je_sélectionne_une_commande_à_payer() {
		commanderejeterpageobject.selectionneCommande();
	}
	@When("I click on reject")
	public void je_clique_sur_rejeter() {
		commanderejeterpageobject.rejeterCommande();
	}
	@Then("A confirmation message is displayed Rej")
	public void Un_message_de_rejeter_avec_sucées_s_affiche() {
		commanderejeterpageobject.verifyRejeterCommandeSucced();
	}



	

}