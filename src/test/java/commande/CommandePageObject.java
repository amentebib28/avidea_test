package commande;
import static Utils.DriverManager.getDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CommandePageObject {
final static String AHREF_COMMANDE = "ORDERS_MENU_ITEM_SUB";
final static String AHREF_COMMANDE_ENVOYE = "//a[contains(., 'Commandes envoyées')]";
final static String BTN_AJOUTER = "//button[contains(text(), 'Ajouter')]";
final static String NBRE_CARTES="inputNumberOfCards";
final static String BTN_SAUVEGARDER = "//button[contains(text(), 'Sauvegarder')]";
final static String BTN_ENVOYER="//div[contains(text(),'Envoyer')]";
final static String BTN_PAYER="//div[contains(text(),'Payer')]";
final static String DATE_PAIEMENT="//input[@placeholder='jj/mm/aaaa']";
final static String MODE_PAIEMENT="inputModeTransfer";
final static String PAYMENT_NUMBER="inputPaymentNumber";
final static String SELECTION_BANK="inputBanks";
final static String JUSTIFICATION="//span[text()=' Ajouter un justificatif ']";
final static String BTN_CONFIRMER2 = "//div[@class='app-modal-footer']//button[contains(text(),'Confirmer')]";
final static String BTN_VIREMENT="inputModeTransfer";
final static String MSG_VERIF="span.toast-title.ng-star-inserted";
final static String PAYEE="span.tag";
@FindBy(how = How.ID, using = AHREF_COMMANDE)
    public WebElement ahref_commande;

@FindBy(how = How.XPATH, using = AHREF_COMMANDE_ENVOYE)
   public WebElement ahref_commande_envoye;
@FindBy(how = How.XPATH, using = BTN_AJOUTER)
   public WebElement btn_ajouter;
@FindBy(how = How.ID, using = NBRE_CARTES)
   public WebElement nbre_cartes;
@FindBy(how = How.XPATH, using = BTN_SAUVEGARDER)
   public WebElement btn_sauvegarder;
@FindBy(how = How.XPATH, using = BTN_ENVOYER)
   public WebElement btn_envoyer;
@FindBy(how = How.XPATH, using = BTN_PAYER)
   public WebElement btn_payer;
@FindBy(how = How.XPATH, using = DATE_PAIEMENT)
   public WebElement date_paiement;
@FindBy(how = How.ID, using = MODE_PAIEMENT)
   public WebElement mode_paiement;
@FindBy(how = How.ID, using = PAYMENT_NUMBER)
   public WebElement payment_number;
@FindBy(how = How.ID, using = SELECTION_BANK)
   public WebElement selection_bank;

@FindBy(how = How.XPATH, using = JUSTIFICATION)
   public WebElement justification;
@FindBy(how = How.XPATH, using = BTN_CONFIRMER2)
   public WebElement btn_confirmer2;
@FindBy(how = How.ID, using = BTN_VIREMENT)
   public WebElement btn_virement;
@FindBy(how = How.CSS, using = MSG_VERIF)
   public WebElement msg_verif;
@FindBy(how = How.CSS, using = PAYEE)
   public WebElement payee;


public void goToCommandes() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(ahref_commande)).click();
         wait.until(ExpectedConditions.elementToBeClickable(ahref_commande_envoye)).click();
         WebElement ajouterButton = wait.until(ExpectedConditions.visibilityOf(btn_ajouter));
         ajouterButton.click();
                               
    }
public void saisirData() {
WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(nbre_cartes));
nbre_cartes.sendKeys("20");
}



public void cliqueSauvegarder() {
WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
WebElement ajouterSauvegarder = wait.until(ExpectedConditions.visibilityOf(btn_sauvegarder));
ajouterSauvegarder.click();
}
         public void cliqueEnvoyer() throws InterruptedException  {
       
WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(btn_envoyer)).click();
         
   
         WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.cssSelector(".basic.modal.in.asic.fade")));
         WebElement modalHeader = modal.findElement(By.cssSelector(".modal-header .modal-title"));

         String modalTitle = modalHeader.getText();

         if (modalTitle.equals("Envoyer la commande de Cartes Vertes")) {
             System.out.println("Title matched!");

             WebElement confirmerButton = modal.findElement(By.xpath(".//button[contains(text(), 'Confirmer')]"));
             wait.until(ExpectedConditions.elementToBeClickable(confirmerButton));
             JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

             jsExecutor.executeScript("arguments[0].scrollIntoView(true);", confirmerButton);
             try {  
            Thread.sleep(500);

             } catch (InterruptedException e) {

                 e.printStackTrace();
             }
             jsExecutor.executeScript("arguments[0].click();", confirmerButton);
         } else {
             System.out.println("Title not found: " + modalTitle);

         }}
         public WebDriver createDriver() {
             ChromeOptions options = new ChromeOptions();
             String downloadDir = "C:\\eclipse\\ws\\autotest\\autotest\\src\\commandePDF";
             options.addArguments("download.default_directory=" + downloadDir);
             options.addArguments("safebrowsing.enabled=true");
             WebDriver downloadDriver = new ChromeDriver(options);
             return downloadDriver;
         }

         public void telechargerDoc() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
           WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("//span[text()='Télécharger']")));

           JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
           jsExecutor.executeScript("arguments[0].scrollIntoView(true);", downloadButton);
           File downloadFolder = new File("C:/eclipse/ws/autotest/autotest/src/commandePDF");
           if (downloadFolder.exists() && downloadFolder.isDirectory()) {
               for (File file : downloadFolder.listFiles()) {
                   if (file.isFile()) {
                       file.delete();
                   }
               }
           }
           downloadButton.click();
           jsExecutor.executeScript("window.scrollTo(0, 0);");
           System.out.println("Download initiated");         }


       
       
       
       
       
         public void cliquePayer()  {
       

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_payer)).click();
       
       
       
             
               
               
             
         }
         public void saisirDataCommande() throws AWTException, InterruptedException {
       
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(date_paiement));
       
        date_paiement.clear();
             date_paiement.sendKeys("23042025");  
       
        wait.until(ExpectedConditions.elementToBeClickable(btn_virement)).click();
       
        payment_number.sendKeys("8432412321");
       
        wait.until(ExpectedConditions.visibilityOf(selection_bank));
        selection_bank.click();
       
             List<WebElement> bank = getDriver().findElements(By.cssSelector("div.ng-option"));
             bank.get(3).click();
             WebElement addJustificatifButton = wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("//span[text()=' Ajouter un justificatif ']")));
            addJustificatifButton.click();
            Thread.sleep(1000);
           
               
                StringSelection filePath = new StringSelection("vc");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
               
                Robot robot = new Robot();
                robot.delay(1000);
               
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

               
                robot.delay(1000);

               
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(5000);
               
               
         }

         
         
         public void cliqueConfirmer2() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                     By.cssSelector(".basic.modal.in.asic.fade")));
           
                 WebElement confirmerButton = modal.findElement(By.xpath(".//button[contains(text(), 'Confirmer')]"));
                 wait.until(ExpectedConditions.elementToBeClickable(confirmerButton));
                 JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

                 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", confirmerButton);
                 try {  
                Thread.sleep(500);

                 } catch (InterruptedException e) {

                     e.printStackTrace();
                 }
                 jsExecutor.executeScript("arguments[0].click();", confirmerButton);
             }

         public void verifyAddCommandeSucced() {
      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOf(msg_verif));
      String expectedMsg="Commande payée avec succès";
      String actuelMsg=msg_verif.getText();
      Assert.assertEquals(expectedMsg, actuelMsg);
      wait.until(ExpectedConditions.visibilityOf(payee));
    String expectedDraft="Payée";
    String actuelDraft=payee.getText();
    Assert.assertEquals(expectedDraft,actuelDraft);
    //Assert background color
   
   
    String bgExpected="rgba(147, 197, 114, 1)";
    String bgColor=payee.getCssValue("background-color");
    Assert.assertEquals(bgExpected,bgColor);
      }
}
