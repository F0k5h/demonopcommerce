package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
public class D01_registerStepDef {
    P01_register register = new P01_register();
    @Given("user go to register page")
    public void goRegisterPage(){
        register.registerLink.click();
    }
    @When("user select gender type")
    public void userSelectGenderType() {
        register.genderMale.click();
    }
    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstName.sendKeys(arg0);
        register.lastName.sendKeys(arg1);
    }
    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay = new Select(register.fillDay);
        selectDay.selectByIndex(29);
        Select selectMonth = new Select(register.fillMonth);
        selectMonth.selectByValue("11");
        Select selectYear = new Select(register.fillYear);
        selectYear.selectByVisibleText("1997");
    }
    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.eMail.sendKeys(arg0);
    }
    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.passWord.sendKeys(arg0);
        register.confirmPassWord.sendKeys(arg1);
    }
    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerButton.click();
    }
    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.completedRegisteration.getText().contains("Your registration completed"));
        soft.assertEquals(register.completedRegisteration.getCssValue("color"),"rgba(76, 177, 124, 1)");
        soft.assertAll();
    }
}