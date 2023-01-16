package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static org.example.stepDefs.Hooks.driver;
public class D08_wishlistStepDef {
    P03_homePage wishlist = new P03_homePage();
    @When("click on wishlist button {string} on this product {string}")
    public void clickOnWishlistButtonOnThisProduct(String arg0, String arg1) {
        wishlist.wishlistButton.click();
    }
    @Then("use see success message {string} with green background color")
    public void useSeeSuccessMessageWithGreenBackgroundColor(String arg0) {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(wishlist.wishlistMsg.getText().contains(arg0));
        soft.assertEquals(Color.fromString(wishlist.wishlistMsg.getCssValue("background-color")).asHex(),"#4bb07a");
        soft.assertAll();
    }
    @And("wait until success message with green color to disappear")
    public void waitUntilSuccessMessageWithGreenColorToDisappear() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.invisibilityOf(wishlist.wishlistMsg));
    }
    @And("click on {string} Tab on the top of the page")
    public void clickOnTabOnTheTopOfThePage(String arg0) {
        wishlist.wishlistMenu.click();
    }
    @Then("Qty value is bigger than {int}")
    public void qtyValueIsBiggerThan(int arg0) {
        Assert.assertTrue(Integer.parseInt(wishlist.qty.getAttribute("value"))>arg0);
    }
}