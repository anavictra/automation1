package managers.Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utility.Constants;

import java.net.MalformedURLException;
import java.net.URL;

import static pages.BasePage.driver;

public class FirefoxBrowser extends Browser {

    public FirefoxBrowser() throws MalformedURLException {

        this.name = "firefox";
        this.capabilities = new DesiredCapabilities();
        String platform = System.getProperty("platform");

        if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()) {
            //System.setProperty("webdriver.firefox.marionette",(System.getProperty("user.dir") + "\\geckoDriver\\geckodriver"));
            this.capabilities = DesiredCapabilities.firefox();
            this.capabilities.setCapability("marionette", false);
            driver = new RemoteWebDriver(new URL(Constants.gridMachine), this.capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (driver == null) {
            switch (platform) {
                case "mac":
                    System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "\\src\\main\\resources\\geckoDriver\\geckodriver"));
                    break;
                case "windows":
                    System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "\\src\\main\\resources\\geckoDriver\\geckodriver.exe"));

                    break;
            }
            //capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }
}
