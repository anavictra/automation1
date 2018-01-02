package managers.Browsers;

import utility.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static pages.BasePage.driver;

public class InternetExplorerBrowser extends Browser {

    public InternetExplorerBrowser() throws MalformedURLException {

        this.name = "ie";
        this.capabilities = new DesiredCapabilities();

        if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()) {
            this.capabilities = DesiredCapabilities.internetExplorer();
            //capabilities.setCapability("ie.ensureCleanSession", true);
            //capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("requireWindowFocus", true);
            driver = new RemoteWebDriver(new URL(Constants.gridMachine), this.capabilities);
            driver.manage().window().maximize();
        } else {
            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "\\chromedriver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
}
