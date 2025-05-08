package commandeValider;

import static Utils.DriverManager.getDriver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommandeValiderPageObject {
	final static String AHREF_COMMANDE_ASSURANCE = "//a[contains(., 'Commandes Assurances')]";  
	final static String COMMANDE=".//td[1]/a"; 
	final static String VALIDER="//div[text()='Valider']";
	final static String MSG_VERIF="span.toast-title.ng-star-inserted";
	final static String VALIDER_BTN="span.tag";
	
	
	@FindBy(how = How.XPATH, using = AHREF_COMMANDE_ASSURANCE)
    public WebElement ahref_commande_assurance;
	@FindBy(how = How.XPATH, using = COMMANDE)
    public WebElement commande;
	@FindBy(how = How.XPATH, using = VALIDER)
    public WebElement valider;
	@FindBy(how = How.CSS, using = MSG_VERIF)
    public WebElement msg_verif;
	@FindBy(how = How.CSS, using = VALIDER_BTN)
    public WebElement valider_btn;

	
	public void pageCommande() {
		ahref_commande_assurance.click();
	}
	public void selectionneCommande() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tbody//tr")));



	    List<WebElement> rows = getDriver().findElements(By.xpath("//table//tbody//tr"));

	    boolean found = false;



	    for (WebElement row : rows) {

	        try {

	            WebElement statusDiv = row.findElement(By.xpath(".//td//div[@class='btn btn-action' and contains(., 'Payée')]"));

	            String statusText = statusDiv.getText().trim();

	            if (statusText.equalsIgnoreCase("Payée")) {

	                WebElement commandeLink = row.findElement(By.xpath(".//td/a"));

	                String uuidHref = commandeLink.getAttribute("href");

	                System.out.println("Found 'Payée'. Clicking link with UUID: " + uuidHref);

	                commandeLink.click();

	                found = true;

	                break;

	            }

	        } catch (NoSuchElementException e) {

	        }

	    }



	    if (!found) {

	        System.out.println("We don't have any Statut equal to 'Payée'.");

	    }

	    

	    Thread.sleep(3000);

	}


        
		
	
	
	public void valideCommande() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(valider)).click();
	
	
         WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector(".basic.modal.in.asic.fade")));
         WebElement modalHeader = modal.findElement(By.cssSelector(".modal-header .modal-title"));

         String modalTitle = modalHeader.getText();

         if (modalTitle.equals("Valider la commande")) {
             System.out.println("Title matched!");

             WebElement ValiderButton = modal.findElement(By.xpath(".//button[contains(text(), 'Valider')]"));
             wait.until(ExpectedConditions.elementToBeClickable(ValiderButton));
             JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

             jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ValiderButton);
             try {  
            	 Thread.sleep(500);

             } catch (InterruptedException e) {

                 e.printStackTrace();
             }
             jsExecutor.executeScript("arguments[0].click();", ValiderButton);
         } else {
             System.out.println("Title not found: " + modalTitle);

         }}
         public void verifyValiderCommandeSucced() {
      		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
      		wait.until(ExpectedConditions.visibilityOf(msg_verif));
      		String expectedMsg="Commande validée avec succès";
      		String actuelMsg=msg_verif.getText();
      		Assert.assertEquals(expectedMsg, actuelMsg);
      		wait.until(ExpectedConditions.visibilityOf(valider_btn));
     		String expectedDraft="Validée";
     		String actuelDraft=valider_btn.getText();
     		Assert.assertEquals(expectedDraft,actuelDraft);
     		//Assert background color 
     		
     		
     		String bgExpected="rgba(12, 167, 136, 1)";
     		String bgColor=valider_btn.getCssValue("background-color");
     		Assert.assertEquals(bgExpected,bgColor);
      		}
         
	
	
	
	}
















