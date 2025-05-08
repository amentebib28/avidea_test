package logout;


import static Utils.DriverManager.getDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import static org.junit.Assert.assertEquals;
public class LogoutPageObject {
	
	
	final static String BTN_PARAMETRE="user-profile";
	final static String BTN_LOGOUT="//a[contains(text(), 'Se déconnecter')]";
	
	
	@FindBy(how = How.CLASS_NAME, using = BTN_PARAMETRE)
    public WebElement btn_parametre;
	@FindBy(how = How.XPATH, using = BTN_LOGOUT)
    public WebElement btn_logout;
	
	public void parametre_click() {
	
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_parametre));
        btn_parametre.click();
	}
	
	
	public void logout_click() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_logout)).click();

	}
	
	
	public void rediriger_login() {
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.urlContains("https://test.buat.avidea.tn/#/login"));
	
	}
}
