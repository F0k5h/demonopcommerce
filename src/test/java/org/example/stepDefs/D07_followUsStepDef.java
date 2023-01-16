package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import java.util.ArrayList;
import static org.example.stepDefs.Hooks.driver;
public class D07_followUsStepDef {
    P03_homePage followUs = new P03_homePage();
    @When("user opens {string} link")
    public void userOpensLink(String arg0){
        switch (arg0) {
            case "facebook" -> followUs.networks.get(0).click();
            case "twitter" -> followUs.networks.get(1).click();
            case "rss" -> followUs.networks.get(2).click();
            case "youtube" -> followUs.networks.get(3).click();
        }
    }
    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),arg0);
        driver.close();
    }
}