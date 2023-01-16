package org.example.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.example.stepDefs.Hooks.driver;
public class P03_homePage {
    public P03_homePage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "option[value]")
    public List<WebElement> currency;
    @FindBy(css = "span[class=\"price actual-price\"]")
    public List<WebElement> price;
    @FindBy(className = "search-box-text")
    public WebElement searchField;
    @FindBy(className = "search-box-button")
    public WebElement searchButton;
    @FindBy(css = "h2[class=\"product-title\"] a")
    public List<WebElement> searchResult;
    @FindBy(css = "div[class=\"sku\"] span[class=\"value\"]")
    public WebElement sku;
    @FindBy(css = "ul[class=\"top-menu notmobile\"]>li>a")
    public List<WebElement> topMenue;
    @FindBy(css = "div[class=\"page-title\"] h1")
    public WebElement pageTitle;
    @FindBy(className = "nivo-imageLink")
    public List<WebElement> sliders;
    @FindBy(css = "ul[class=\"networks\"] li")
    public List<WebElement> networks;
    @FindBy(css = "div[data-productid=\"18\"] button[class=\"button-2 add-to-wishlist-button\"]")
    public WebElement wishlistButton;
    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement wishlistMsg;
    @FindBy(className = "wishlist-label")
    public WebElement wishlistMenu;
    @FindBy(className = "qty-input")
    public WebElement qty;
}