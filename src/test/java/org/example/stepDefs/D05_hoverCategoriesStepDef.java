package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;
import java.util.Random;
import static org.example.stepDefs.Hooks.driver;
public class D05_hoverCategoriesStepDef {
    P03_homePage hover = new P03_homePage();
    String categoryName;
    @When("user select random category or sub category")
    public void userSelectRandomCategoryOrSubCategory() {
        Actions hoverElement = new Actions(driver);
        int ranMainCategory1 = new Random().nextInt(hover.topMenue.size());
        int ranMainCategory2 = ranMainCategory1+1;
        hoverElement.moveToElement(hover.topMenue.get(ranMainCategory1)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        int subRandomNum = driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li:nth-child("+ranMainCategory2+")>ul>li")).size();
        if (subRandomNum>0){
            int ranSubCategory1 = new Random().nextInt(subRandomNum);
            int ranSubCategory2 = ranSubCategory1+1;
            categoryName = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"]>li:nth-child("+ranMainCategory2+")>ul>li:nth-child("+ranSubCategory2+")>a")).getText().toLowerCase().trim();
            driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"]>li:nth-child("+ranMainCategory2+")>ul>li:nth-child("+ranSubCategory2+")>a")).click();
        }
        else {
            categoryName = hover.topMenue.get(ranMainCategory1).getText().toLowerCase().trim();
            hover.topMenue.get(ranMainCategory1).click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("category or sub-category title contains the one user chose")
    public void categoryOrSubCategoryTitleContainsTheOneUserChose() {
        Assert.assertTrue(hover.pageTitle.getText().toLowerCase().trim().contains(categoryName));
    }
}