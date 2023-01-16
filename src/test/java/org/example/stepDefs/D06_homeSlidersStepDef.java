package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static org.example.stepDefs.Hooks.driver;
public class D06_homeSlidersStepDef {
    P03_homePage slider = new P03_homePage();
    @When("first slider is clickable")
    public void firstSliderIsClickable() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.attributeContains(slider.sliders.get(0),"style","display: block;"));
    }
    @And("click on first slider")
    public void clickOnFirstSlider() {
        slider.sliders.get(0).click();
    }
    @Then("user go to url {string}")
    public void userGoToUrl(String arg0) {
        Assert.assertTrue(driver.getCurrentUrl().contains(arg0));
    }
    @When("second slider is clickable")
    public void secondSliderIsClickable() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.attributeContains(slider.sliders.get(1),"style","display: block;"));
    }
    @And("click on second slider")
    public void clickOnSecondSlider() {
        slider.sliders.get(1).click();
    }
}