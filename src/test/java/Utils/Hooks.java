package Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static Utils.DriverManager.getDriver;
import static Utils.DriverManager.quitDriver;

public class Hooks {
	@Before
	public void setUp() {
		getDriver();
	}
	@After
	public void tearDown(Scenario scenario) {
		WebDriver driver = getDriver();
	if (scenario.isFailed()) {
		byte[]screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot,"image/png",scenario.getName());
	}
	quitDriver();
	}
}
