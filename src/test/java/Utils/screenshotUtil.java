package Utils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
public class screenshotUtil {
    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + UUID.randomUUID() + ".png";
            String destinationPath = "target/screenshots/" + screenshotName;
            Files.createDirectories(Paths.get("target/screenshots"));
            Files.copy(src.toPath(), Paths.get(destinationPath));
            return destinationPath;

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

}

