package hooks;

import browserfactory.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utility.ConfigReader;
import utility.Helper;

import java.util.Properties;

public class Hook {
    WebDriver driver;

    @Before
    public void setup() {
        Properties prop = new ConfigReader().intializeProperties();
        driver = Browser.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            byte[] screenshot = Helper.captureScreenshotinByte(driver);
            scenario.attach(screenshot, "image/png", scenarioName);
        }
        driver.quit();
    }
}
