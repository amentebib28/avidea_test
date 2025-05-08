package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static Utils.DriverManager.getDriver;

public class LoginStepDef {

	private WebDriver driver;
	private LoginPageObject loginpageobject;

	@Given("I open the login page")
	public void I_open_the_login_page() {
		driver = getDriver();

		driver.get("https://test.buat.avidea.tn/#/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		loginpageobject = PageFactory.initElements(driver, LoginPageObject.class);
	}

	@When("I enter my email address {string} and my password {string}")
	public void je_saisis_mon_adresse_email_et_mon_mot_de_passe(String email, String motdepasse) {
		loginpageobject.email(email);
		loginpageobject.motdepasse(motdepasse);
		loginpageobject.button();

	}

	@Then("I am redirected to the home page")
	public void je_suis_redirigé_vers_la_page_d_accueil() {
		loginpageobject.verify_login_succed();

	}

//scenario Outline
	@When("je saisis {string} et {string} incorrecte")
	public void je_saisis_et_incorrecte(String email, String motdepasse) {
		loginpageobject.email(email);
		loginpageobject.motdepasse(motdepasse);
		loginpageobject.button();
	}

	@Then("je vois {string}")
	public void je_vois(String errorMessage) {
		loginpageobject.verify_error_message(errorMessage);

	}

}
