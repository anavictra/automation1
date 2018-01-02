package stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.Browsers.BrowserFactory;
import utility.GeneralUtils;
import utility.Navigation;

import static pages.BasePage.driver;

public class Hooks {

    @Before(order = 1, value = "@All")
    public void setupSeleniumDriver() throws Exception {

        BrowserFactory.getBrowser(System.getProperty("browser"));
        Navigation.goToPage("LoginPage");
    }

    @After("@All")
    public void tearDownSeleniumDriver(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            scenario.write("Current page " + driver.getCurrentUrl());
            GeneralUtils.embedScreenshot(scenario);
        }

        BrowserFactory.closeBrowser();
    }
}