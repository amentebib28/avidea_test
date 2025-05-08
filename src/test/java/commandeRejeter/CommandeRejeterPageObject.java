package commandeRejeter;
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

public class CommandeRejeterPageObject {
	final static String AHREF_COMMANDE_ASSURANCE = "//a[contains(., 'Commandes Assurances')]";  
	final static String COMMANDE=".//td[1]/a"; 
	final static String MSG_VERIF="span.toast-title.ng-star-inserted";
	final static String REJETER_BTN="span.tag";
	final static String MOTIF_REJETER="inputMotif";
	
	
	
	@FindBy(how = How.XPATH, using = AHREF_COMMANDE_ASSURANCE)
    public WebElement ahref_commande_assurance;
	@FindBy(how = How.XPATH, using = COMMANDE)
    public WebElement commande;
	@FindBy(how = How.ID, using = MOTIF_REJETER)
    public WebElement motif_rejeter;
	@FindBy(how = How.CSS, using = MSG_VERIF)
    public WebElement msg_verif;
	@FindBy(how = How.CSS, using = REJETER_BTN)
    public WebElement rejeter_btn;

	
	public void pageCommande() {
		ahref_commande_assurance.click();
	}
	public void selectionneCommande() {
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(commande)).click();
        
		}
	
	
	public void rejeterCommande() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		WebElement btnRejeter = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//div[contains(text(), 'Rejeter')]")
		));
		btnRejeter.click();
	
	
         WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector(".basic.modal.in.asic.fade")));
         WebElement modalHeader = modal.findElement(By.cssSelector(".modal-header .modal-title"));

         String modalTitle = modalHeader.getText();

         if (modalTitle.equals("Rejeter la commande")) {
             System.out.println("Title matched!");
             wait.until(ExpectedConditions.visibilityOf(motif_rejeter));
             motif_rejeter.click();
             List<WebElement> motif_r = getDriver().findElements(By.cssSelector("div.ng-option"));
             motif_r.get(2).click();
           
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
         public void verifyRejeterCommandeSucced() {
      		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
      		wait.until(ExpectedConditions.visibilityOf(msg_verif));
      		String expectedMsg="Commande rejetée avec succès";
      		String actuelMsg=msg_verif.getText();
      		Assert.assertEquals(expectedMsg, actuelMsg);
      		wait.until(ExpectedConditions.visibilityOf(rejeter_btn));
     		String expectedDraft="Rejetée";
     		String actuelDraft=rejeter_btn.getText();
     		Assert.assertEquals(expectedDraft,actuelDraft);
     		//Assert background color 
     		
     		
     		String bgExpected="rgba(255, 23, 23, 1)";
     		String bgColor=rejeter_btn.getCssValue("background-color");
     		Assert.assertEquals(bgExpected,bgColor);
      		}
         
	
	
	
	}