package org.example.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.stepDefs.Hooks.driver;
public class P01_register {
    //pagefactory
    public P01_register()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerLink;
    @FindBy(id="gender-male")
    public WebElement genderMale;
    @FindBy(id="FirstName")
    public WebElement firstName;
    @FindBy(id="LastName")
    public WebElement lastName;
    @FindBy(css = "select[name=\"DateOfBirthDay\"]")
    public WebElement fillDay;
    @FindBy(css = "select[name=\"DateOfBirthMonth\"]")
    public WebElement fillMonth;
    @FindBy(css = "select[name=\"DateOfBirthYear\"]")
    public WebElement fillYear;
    @FindBy(id="Email")
    public WebElement eMail;
    @FindBy(id="Password")
    public WebElement passWord;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmPassWord;
    @FindBy(id="register-button")
    public WebElement registerButton;
    @FindBy(className = "result")
    public WebElement completedRegisteration;
}