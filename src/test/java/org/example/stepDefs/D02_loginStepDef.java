package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void goLoginPage(){
        login.loginLink.click();
    }
    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1, String arg2) {
        login.email.sendKeys(arg1);
        login.password.sendKeys(arg2);
    }
    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton.click();
    }
    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        soft.assertTrue(login.myAccount.isDisplayed());
        soft.assertAll();
    }
    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.errorMsg.getText().contains("Login was unsuccessful."));
        soft.assertEquals(Color.fromString(login.errorMsg.getCssValue("color")).asHex(),"#e4434b");
        soft.assertAll();
    }
}