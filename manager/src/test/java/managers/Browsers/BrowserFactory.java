package managers.Browsers;

import java.net.MalformedURLException;

import static pages.BasePage.driver;

public class BrowserFactory {

    public static Browser getBrowser(String browserName) throws MalformedURLException {

        if (browserName == null ){
            browserName = "chrome";
        }
        Browser browser = null;
        switch (browserName) {
            case "firefox":
                browser = new FirefoxBrowser();
                break;
            case "chrome":
                browser = new ChromeBrowser();
                break;
            case "ie":
                browser = new InternetExplorerBrowser();
                break;
        }

        return browser;
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
