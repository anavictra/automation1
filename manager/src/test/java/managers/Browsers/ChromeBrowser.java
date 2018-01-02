package managers.Browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utility.Constants;

import java.net.MalformedURLException;
import java.net.URL;

import static pages.BasePage.driver;

public class ChromeBrowser extends Browser {

    public ChromeBrowser() throws MalformedURLException {
        this.name = "chrome";
        this.capabilities = new DesiredCapabilities();
        String platform = System.getProperty("platform");


        if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()) {
            this.capabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(Constants.gridMachine), this.capabilities);
            driver.manage().window().maximize();
        } else {
            switch (platform) {
                case "mac":
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "\\src\\test\\resources\\chromeDriver\\chromedriver"));
                    break;
                case "windows":
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "\\src\\test\\resources\\chromeDriver\\chromedriver.exe"));

                    break;
            }

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--auto-select-desktop-capture-source=" + "Entire Screen"); // When using only one screen
//            options.addArguments("--auto-select-desktop-capture-source="+"Screen 1"); // When using two screens
//            options.addArguments("--use-fake-ui-for-media-stream=1");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.navigate().refresh();
        }
    }
}
