package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("user select Euro currency")
    public void userSelectEuroCurrency() {
        homePage.currency.get(1).click();
    }
    @Then("currency is changed correctly to the euro symbol {string}")
    public void currencyIsChangedCorrectlyToTheEuroSymbol(String arg0) {
        for (int i = 0;i<homePage.price.size();i++)
            Assert.assertTrue(homePage.price.get(i).getText().contains(arg0));
    }
}