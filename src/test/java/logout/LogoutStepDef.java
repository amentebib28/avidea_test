package logout;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.DriverManager.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.And;


public class LogoutStepDef {
	private WebDriver driver;
	//private JSONObject data ;
	private LogoutPageObject logoutpageobject;

@When("I click on the user menu")
public void je_clique_sur_le_menu_utilisateur() {
	
	driver = getDriver();
	logoutpageobject=PageFactory.initElements(driver,LogoutPageObject.class);
	logoutpageobject.parametre_click();
}
@And("I select the Logout option")
public void And_je_sélectionne_l_option_Se_déconnecter() {
	logoutpageobject.logout_click();
	
}
@Then("I am redirected to the login page")
public void Then_je_est_redirigé_vers_la_page_de_connexion() {
	logoutpageobject.rediriger_login();
}

}
