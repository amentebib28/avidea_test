package login;
import static Utils.DriverManager.getDriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPageObject {
	
	final static String INPUT_EMAIL = "//input[@placeholder='Email']";
    final static String INPUT_PASSWORD = "//input[@placeholder='Mot de passe']";
    final static String BTN_LOGIN = "//button[contains(text(),'Se connecter')]";
    @FindBy(how = How.XPATH, using = INPUT_EMAIL)
    public WebElement inputEmail;

    @FindBy(how = How.XPATH, using = INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(how = How.XPATH, using = BTN_LOGIN)
    public WebElement btnLogin;

	public void email(String email) {
		inputEmail.sendKeys(email);

	}

	public void motdepasse(String motdepasse) {
		inputPassword.sendKeys(motdepasse);
	}

	public void button() {
		btnLogin.click();

	}
	public void verify_login_succed() {
	
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("/dashboard"));
	    String expectedUrl= "https://test.buat.avidea.tn/#/dashboard";
	    String actualUrl=getDriver().getCurrentUrl();
		assertEquals(expectedUrl,actualUrl);
	  
	    
		
	}
	public void verify_error_message(String errorMessage) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.icons-alert.alert.background-error span")));

	    String actualText = getDriver().findElement(By.cssSelector("div.icons-alert.alert.background-error span")).getText();
	    assertEquals(errorMessage,actualText);
	    wait.until(ExpectedConditions.urlContains("/login"));
	    String actualUrl=getDriver().getCurrentUrl();
	    String expectedUrl="https://test.buat.avidea.tn/#/login";
	    assertEquals(expectedUrl,actualUrl);

	}
}
