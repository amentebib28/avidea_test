package commande;

import static Utils.DriverManager.getDriver;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommandeStepDef {
	private WebDriver driver;
	//private JSONObject data ;
	private CommandePageObject commandepageobject;
	@When("I have added an order from the Orders section")
	public void j_ai_ajouté_une_commande_depuis_la_section_commandes() {
		driver = getDriver();
		commandepageobject=PageFactory.initElements(driver,CommandePageObject.class);
		commandepageobject.goToCommandes();
	}

	@And("I have filled in the required fields to create an order")
	public void j_ai_remplit_les_champs_nécessaires_pour_créer_une_commande() {
		commandepageobject.saisirData();
	}

	@And("I clicked the Save button")
	public void j_ai_cliqué_sur_le_bouton_sauvegarder() {
		commandepageobject.cliqueSauvegarder();
	    
	}

	@And("I submitted the green card order")
	public void j_ai_envoyé_la_commande_de_cartes_vertes() throws InterruptedException  {
		commandepageobject.cliqueEnvoyer();
	}

	@And("I downloaded the purchase order")
	public void j_ai_téléchargé_le_bon_de_commande() {
		commandepageobject.telechargerDoc();
	}

	@And("I clicked the Pay button")
	public void j_ai_cliqué_sur_le_bouton_payer() {
		commandepageobject.cliquePayer();
	}

	@And("I filled in the payment information for the order")
	public void j_ai_rempli_les_informations_de_paiement_de_la_commande()  throws AWTException,InterruptedException {
		commandepageobject.saisirDataCommande();
	}

	@And("I clicked the Confirm button")
	public void j_ai_cliqué_sur_le_bouton_Confirmer() {
		commandepageobject.cliqueConfirmer2();
	}

	@Then("The order is successfully paid")
	public void la_commande_est_payée_avec_succès() {
		commandepageobject.verifyAddCommandeSucced();
	   
	}

}
