package stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utility.Constants;
import utility.GeneralUtils;

import static pages.BasePage.driver;

public class LoginStepDef extends BaseStepDef {

    @Given("^I am at the login page$")
    public void iAmAtTheLoginPage() throws Throwable {

        GeneralUtils.waitForPageLoaded();
        Thread.sleep(300);
        Assert.assertTrue("I am at the home page", driver.getCurrentUrl().contains(Constants.urlLogin));
    }

//
//    @And("^I press button log in$")
//    public void iPressButtonLogIn() throws Throwable {
//        clickButton(lp.btn_log_in);
//    }


}
