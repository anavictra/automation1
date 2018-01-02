package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public static RemoteWebDriver driver;

    public BasePage() {

        PageFactory.initElements(driver, this);

    }
}
