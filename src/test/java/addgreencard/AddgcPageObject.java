package addgreencard;

import static Utils.DriverManager.getDriver;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddgcPageObject {
	
	
	final static String AHREF_CARTES = "CARDS_MENU_ITEM";
    final static String AHREF_CARTE_VERTES = "//a[contains(., 'Cartes Vertes')]";
    final static String BTN_AJOUTER = "//button[contains(text(), 'Ajouter')]";
    final static String NEW_PAGE_ELEMENT_XPATH="div.newPageElement";
    final static String POLICY_NUMBER = "policyNumber";
    final static String INSURED_REGISTRATION_NUMBER = "insuredRegistrationNumber";
    final static String FIRST_NAME = "firstName";
    final static String LAST_NAME = "lastName";
    final static String ADDRESS = "address";
    final static String CHASSIS_NUMBER = "chassisNumber";
    final static String ENGINE_NUMBER="engineNumber";
    final static String BRAND = "brand";
    final static String USAGE = "usage";
    final static String MODEL = "typeMine";
    final static String CATEGORY = "category";
    final static String IMMATRICULATION = "inputPlateType";
    final static String DATE = "//input[@placeholder='jj/mm/aaaa']";
    
    final static String INSURED_TYPE = "insuredType";
    final static String NATIONALITY = "nationality";
    final static String BTN_SAUVEGARDER = "//button[contains(text(),'Sauvegarder')]";
    final static String BTN_ANNULER= "//button[contains(text(),'Annuler')]";

    final static String EMAIL="email";
    final static String PHONE="phone";
    final static String NUMERO_IMMA = "//input[@placeholder='N°']";
    final static String SERIE_IMMA = "//input[@placeholder='Série']";
    final static String MSG_VERIF="span.toast-title.ng-star-inserted";
    final static String BROUILLON="span.tag";
    

    
    
    
    
    @FindBy(how = How.ID, using = AHREF_CARTES)
    public WebElement ahref_cartes;

    @FindBy(how = How.XPATH, using = AHREF_CARTE_VERTES)
    public WebElement ahref_carte_vertes;
   

    @FindBy(how = How.XPATH, using = BTN_AJOUTER)
    public WebElement btn_ajouter;
   
    
    @FindBy(how = How.ID , using = POLICY_NUMBER)
    public WebElement policy_number;
    
    @FindBy(how = How.ID , using = INSURED_REGISTRATION_NUMBER)
    public WebElement insuredRegistrationNumber;
    
    @FindBy(how = How.ID , using = FIRST_NAME)
    public WebElement first_name;
    
    @FindBy(how = How.ID , using = LAST_NAME)
    public WebElement last_name;
    
    @FindBy(how = How.ID , using = ADDRESS)
    public WebElement address;
    
    @FindBy(how = How.ID , using = CHASSIS_NUMBER)
    public WebElement chassis_number;
    
    @FindBy(how = How.ID , using = BRAND)
    public WebElement brand;
    
    @FindBy(how = How.ID , using = USAGE)
    public WebElement usage;
    
    @FindBy(how = How.ID , using = MODEL)
    public WebElement model;
    
    @FindBy(how = How.ID , using = CATEGORY)
    public WebElement category;
    @FindBy(how = How.ID, using = ENGINE_NUMBER)
    public WebElement engine_number;
    
    @FindBy(how = How.ID, using = IMMATRICULATION)
    public WebElement immatriculation;
    
    @FindBy(how = How.XPATH, using = DATE)
    public List<WebElement> date;
    
 
    
    @FindBy(how = How.ID, using = INSURED_TYPE)
    public WebElement insured_type;
    
    @FindBy(how = How.ID, using = NATIONALITY)
    public WebElement nationality;
    
    
    @FindBy(how = How.XPATH, using = BTN_SAUVEGARDER)
    public WebElement btn_sauvegarder;
    
    @FindBy(how = How.XPATH, using = BTN_ANNULER)
    public WebElement btn_annuler;
    @FindBy(how = How.XPATH, using = NUMERO_IMMA)
    public WebElement numero_imma;
    @FindBy(how = How.XPATH, using = SERIE_IMMA)
    public WebElement serie_imma;
    @FindBy(how = How.ID, using = EMAIL)
    public WebElement email;
    @FindBy(how = How.ID, using = PHONE)
    public WebElement phone;
    @FindBy(how = How.CSS, using = MSG_VERIF)
    public WebElement msg_verif;
    @FindBy(how = How.CSS, using = BROUILLON)
    public WebElement brouillon;
 
    public void goToAddCards() {
    	 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(ahref_cartes)).click();
         wait.until(ExpectedConditions.elementToBeClickable(ahref_carte_vertes)).click();
         WebElement ajouterButton = wait.until(ExpectedConditions.visibilityOf(btn_ajouter));
         ajouterButton.click();
                               
    }
  public void saisirData() {
	  WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(policy_number)); 
      policy_number.sendKeys(functionRandom(8));
      
      wait.until(ExpectedConditions.visibilityOf(immatriculation));
      immatriculation.click();
      
      List<WebElement> options = getDriver().findElements(By.cssSelector("div.ng-option"));
      options.get(2).click();
      wait.until(ExpectedConditions.visibilityOf(numero_imma));
      numero_imma.sendKeys(numeroImmatriculation());
      
      wait.until(ExpectedConditions.visibilityOf(serie_imma));
      serie_imma.sendKeys(numeroImmatriculation());
      
      wait.until(ExpectedConditions.visibilityOf(date.get(0)));
      date.get(0).sendKeys(getDateToday());
      
      wait.until(ExpectedConditions.visibilityOf(date.get(2)));
      date.get(2).sendKeys(getDateTomorrow());
      
      wait.until(ExpectedConditions.visibilityOf(date.get(3)));
      date.get(3).sendKeys(getDatePlusThree());
      
      wait.until(ExpectedConditions.visibilityOf(insuredRegistrationNumber));
      insuredRegistrationNumber.sendKeys(functionRandom(8));
      
      wait.until(ExpectedConditions.visibilityOf(nationality));
      nationality.click();
      List<WebElement> nationality = getDriver().findElements(By.cssSelector("div.ng-option"));
      nationality.get(5).click();
      
      wait.until(ExpectedConditions.visibilityOf(insured_type));
      insured_type.click();
      
      List<WebElement> insured = getDriver().findElements(By.cssSelector("div.ng-option"));
      insured.get(0).click();    
      
      wait.until(ExpectedConditions.visibilityOf(first_name));     
      first_name.sendKeys("amen");  
      
      wait.until(ExpectedConditions.visibilityOf(last_name));
      last_name.sendKeys("tebib"); 
      
      wait.until(ExpectedConditions.visibilityOf(email));
      email.sendKeys("amenallah@gmail.com");
      
      
      wait.until(ExpectedConditions.visibilityOf(phone));
      phone.sendKeys("27081452");
 
      wait.until(ExpectedConditions.visibilityOf(address));
      address.sendKeys("djerba");
      
      
      wait.until(ExpectedConditions.visibilityOf(chassis_number));
      chassis_number.sendKeys(functionRandom(17));
      
      wait.until(ExpectedConditions.visibilityOf(engine_number));
      engine_number.sendKeys("4342341");
      
      wait.until(ExpectedConditions.visibilityOf(date.get(4)));
      date.get(4).sendKeys(getDateMinusThree()); 
      
      wait.until(ExpectedConditions.visibilityOf(brand));
      brand.click();
      
      List<WebElement> marque = getDriver().findElements(By.cssSelector("div.ng-option"));
      marque.get(0).click();   
      wait.until(ExpectedConditions.visibilityOf(category));
      category.click();
      
      List<WebElement> categorie = getDriver().findElements(By.cssSelector("div.ng-option"));
      categorie.get(0).click();
      
      wait.until(ExpectedConditions.visibilityOf(usage));
      usage.click();
      
      List<WebElement> usaage = getDriver().findElements(By.cssSelector("div.ng-option"));
      usaage.get(0).click();
      
      wait.until(ExpectedConditions.visibilityOf(model));
      model.click();
      
      List<WebElement> modele = getDriver().findElements(By.cssSelector("div.ng-option"));
      modele.get(5).click();
      
      
  }
	public void btn_sauvegarder() {
		btn_sauvegarder.click();
	}
	public void verifyAddCardSucced() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(msg_verif));
		String expectedMsg="Carte ajoutée avec succès";
		String actuelMsg=msg_verif.getText();
		Assert.assertEquals(expectedMsg, actuelMsg);
		//--------
	
		wait.until(ExpectedConditions.visibilityOf(brouillon));
		String expectedDraft="Brouillon";
		String actuelDraft=brouillon.getText();
		Assert.assertEquals(expectedDraft,actuelDraft);
		//Assert background color 
		
		
		String bgExpected="rgba(128, 128, 128, 1)";
		String bgColor=brouillon.getCssValue("background-color");
		Assert.assertEquals(bgExpected,bgColor);
	}
	public void buttonDisable() {
	Assert.assertTrue("Button is not enabled",btn_sauvegarder.isEnabled());
	}
	//function generate random 
	public static String functionRandom(int length) {
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String result="";
		for(int i=0 ; i<length;i++) {
			int index = (int)(Math.random() * chars.length());
	        result += chars.charAt(index);
		}
		return result;
		
	}

	//function random start contrat date today
	public static String getDateToday() {
		LocalDate today=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
		return today.format(formatter);
	}
	//function random start date tomorrow
	public static String getDateTomorrow() {
		LocalDate today=LocalDate.now();
		LocalDate tomorrow=today.plusDays(1);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
		return tomorrow.format(formatter);
	}
	//function random end date +3
		public static String getDatePlusThree() {
			LocalDate today=LocalDate.now();
			LocalDate threeday=today.plusDays(3);
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
			return threeday.format(formatter);
		}
	//function random numero immatriculation
		public static String numeroImmatriculation() {
			int number = (int)(Math.random() * 900) + 100;
			System.out.println(String.valueOf(number));
		    return String.valueOf(number);
		}
	//function random date mise de circulation - three day
		public static String getDateMinusThree() {
			LocalDate today=LocalDate.now();
			LocalDate threeDaysAgo=today.minusDays(3);
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
			return threeDaysAgo.format(formatter);
	}
}
	