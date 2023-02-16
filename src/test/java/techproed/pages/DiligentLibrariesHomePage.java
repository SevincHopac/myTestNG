package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DiligentLibrariesHomePage {

    public DiligentLibrariesHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "dropdown-basic")
    public WebElement usernameBox;
    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logout;
    @FindBy(xpath = "//*[.='OK']")
    public WebElement okButton;
    @FindBy (xpath = "//*[text()='Signin']")
    public WebElement signInButton;


}
