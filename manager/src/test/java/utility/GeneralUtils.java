package utility;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.driver;

public class GeneralUtils {

    public static void embedScreenshot(Scenario scenario) {

        try {
            byte[] screenshot = (driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    public static void waitForPageLoaded() throws InterruptedException {

        Thread.sleep(2500);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


    public static long getSecons(Object microsecons) {

        return TimeUnit.NANOSECONDS.toSeconds(Long.parseLong(microsecons.toString()));
    }

    public static void jsClick(WebElement element) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public static void jsSendkeys(WebElement element, String text) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
    }

    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, Constants.WAIT_MEDIUM)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickAbility(WebElement element) {
        new WebDriverWait(driver, Constants.WAIT_MEDIUM)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
