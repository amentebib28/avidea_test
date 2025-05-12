package addgreencard;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.LoginPageObject;
import io.cucumber.java.en.And;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static Utils.DriverManager.getDriver;

public class AddgcStepDef {
	private WebDriver driver;
	//private JSONObject data ;
	private AddgcPageObject addgcpageobject;
	
	@When("I have added a green card from the Cards section")
	public void j_ai_ajouté_une_carte_verte_depuis_la_section_Cartes() {
		driver = getDriver();
		addgcpageobject=PageFactory.initElements(driver,AddgcPageObject.class);
		addgcpageobject.goToAddCards();
	}		
	@And("I enter valid green card information")
	public void je_saisis_les_informations_valides_de_la_carte_verte() {
		addgcpageobject.saisirData();
	}
	@And("I click the Save button")
	public void clique_sur_le_bouton_sauvegarder() {
		addgcpageobject.btn_sauvegarder();
	}
	@Then("The green card is created successfully")
	public void la_carte_verte_est_créée_avec_succée() {
		addgcpageobject.verifyAddCardSucced();
	}
	//Scenario DATA vide 
	
	@Then("I verify that the Save button is disabled")
	public void je_vérifie_que_le_bouton_Sauvegarder_est_désactivé() {
	    addgcpageobject.buttonDisable();
	}
		
}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
