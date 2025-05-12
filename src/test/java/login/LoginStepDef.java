package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Utils.DriverManager.getDriver;

import java.time.Duration;

public class LoginStepDef {

    private WebDriver driver;
    private LoginPageObject loginpageobject;

    // Méthode d'initialisation commune à tous les scénarios
    private void initLoginPage() {
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        loginpageobject = new LoginPageObject(driver); // ✅ utilise maintenant le constructeur corrigé
    }

    @Given("I enter my email address {string} and my password {string}")
    public void je_saisis_mon_adresse_email_et_mon_mot_de_passe(String email, String motdepasse) {
        initLoginPage();
        loginpageobject.email(email);
        loginpageobject.motdepasse(motdepasse);
        loginpageobject.button();
    }

    @When("I am redirected to the home page")
    public void je_suis_redirigé_vers_la_page_d_accueil() {
        loginpageobject.verify_login_succed();
    }

    @Given("I enter my {string} and {string} invalid")
    public void je_saisis_et_incorrecte(String email, String motdepasse) {
        initLoginPage();
        loginpageobject.email(email);
        loginpageobject.motdepasse(motdepasse);
        loginpageobject.button();
    }

    @When("I see a {string}")
    public void je_vois(String errorMessage) {
        loginpageobject.verify_error_message(errorMessage);
    }
}