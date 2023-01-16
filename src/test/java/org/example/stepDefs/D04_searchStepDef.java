package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();
    @When("user click on search field")
    public void userClickOnSearchField() {
        search.searchField.click();
    }
    @And("user search with {string}")
    public void userSearchWith(String arg0) {
        search.searchField.sendKeys(arg0);
        search.searchButton.click();
    }
    @Then("user could find {string} relative results")
    public void userCouldFindRelativeResults(String arg0) {
        for (int i = 0;i<search.searchResult.size();i++){
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
            soft.assertTrue(search.searchResult.get(i).getText().toLowerCase().contains(arg0));
            soft.assertAll();
        }
    }
    @Then("user could find {string} inside product detail page")
    public void userCouldFindInsideProductDetailPage(String arg0) {
        search.searchResult.get(0).click();
        Assert.assertTrue(search.sku.getText().contains(arg0));
    }
}