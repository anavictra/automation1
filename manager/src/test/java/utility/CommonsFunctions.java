package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.BasePage.driver;

public class CommonsFunctions {

    public void clickButton(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clearText(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
    }

    public void sendText(WebElement element, String text) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    public void uploadFile(WebElement element,String filePath) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(filePath);
    }

    public String getText(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }

    public boolean isEnabled(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean isDisplayed(WebElement element) {

        new WebDriverWait(driver, Constants.WAIT_MEDIUM).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean isElementPresent(WebElement element) {

        boolean result = true;

        try{
            element.isDisplayed();
        }
        catch (NoSuchElementException exception){
            result = false;
        }

        return result;
    }
}
