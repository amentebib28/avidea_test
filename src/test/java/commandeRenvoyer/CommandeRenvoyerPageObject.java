package commandeRenvoyer;

import static Utils.DriverManager.getDriver;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommandeRenvoyerPageObject {
	final static String AHREF_COMMANDE_ASSURANCE = "//a[contains(., 'Commandes Assurances')]";  
	final static String COMMANDE=".//td[1]/a"; 
	final static String RENVOYER="//div[text()='Renvoyer']";
	final static String MSG_VERIF="span.toast-title.ng-star-inserted";
	final static String RENVOYER_BTN="span.tag";
	final static String MOTIF="inputResendReason";
	
	@FindBy(how = How.XPATH, using = AHREF_COMMANDE_ASSURANCE)
    public WebElement ahref_commande_assurance;
	@FindBy(how = How.XPATH, using = COMMANDE)
    public WebElement commande;
	@FindBy(how = How.XPATH, using = RENVOYER)
    public WebElement renvoyer;
	@FindBy(how = How.ID, using = MOTIF)
    public WebElement motif;
	@FindBy(how = How.CSS, using = MSG_VERIF)
    public WebElement msg_verif;
	@FindBy(how = How.CSS, using = RENVOYER_BTN)
    public WebElement renvoyer_btn;

	
	public void pageCommande() {
		ahref_commande_assurance.click();
	}
	public void selectionneCommande() {
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(commande)).click();
        
		}
	
	
	public void renvoyerCommande() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		WebElement btnRejeter = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//div[contains(text(), 'Renvoyer')]")
		));
		btnRejeter.click();
	
	
         WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector(".basic.modal.in.asic.fade")));
         WebElement modalHeader = modal.findElement(By.cssSelector(".modal-header .modal-title"));

         String modalTitle = modalHeader.getText();

         if (modalTitle.equals("Renvoyer la commande")) {
             System.out.println("Title matched!");
             motif.sendKeys("nombre de cartes = 20");
             WebElement ConfirmerButton = modal.findElement(By.xpath(".//button[contains(text(), 'Confirmer')]"));
             wait.until(ExpectedConditions.elementToBeClickable(ConfirmerButton));
             JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
             jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ConfirmerButton);
             try {  
            	 Thread.sleep(500);

             } catch (InterruptedException e) {

                 e.printStackTrace();
             }
             jsExecutor.executeScript("arguments[0].click();", ConfirmerButton);
         } else {
             System.out.println("Title not found: " + modalTitle);

         }}
         public void verifyRenvoyerCommandeSucced() {
      		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
      		wait.until(ExpectedConditions.visibilityOf(msg_verif));
      		String expectedMsg="Commande renvoyée avec succès";
      		String actuelMsg=msg_verif.getText();
      		Assert.assertEquals(expectedMsg, actuelMsg);
      		
      		}
         
	
	
	
	}

