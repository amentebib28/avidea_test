package commandeValider;





import static Utils.DriverManager.getDriver;

import org.openqa.selenium.support.PageFactory;
import static Utils.DriverManager.getDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommandeValiderStepDef {

	private WebDriver driver;

	private CommandeValiderPageObject commandeavaliderpageobject;

	


	@When("I open the list of available orders")
	public void j_ouvre_la_liste_des_commandes_disponibles() {
		driver = getDriver();
		commandeavaliderpageobject=PageFactory.initElements(driver,CommandeValiderPageObject.class);


		commandeavaliderpageobject.pageCommande();
	   
	}
	@When("I select an order to process")
	public void je_sélectionne_une_commande_à_traiter() throws InterruptedException {
		commandeavaliderpageobject.selectionneCommande();
	}
	@When("I click on validate")
	public void je_clique_sur_valider() {
		commandeavaliderpageobject.valideCommande();
	}
	@Then("A confirmation message is displayed")
	public void un_message_de_confirmation_s_affiche() {
		commandeavaliderpageobject.verifyValiderCommandeSucced();
	}



	

}