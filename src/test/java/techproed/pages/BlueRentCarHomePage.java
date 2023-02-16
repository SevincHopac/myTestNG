package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentCarHomePage{

    public BlueRentCarHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginButton;

    @FindBy(id="dropdown-basic-button")
    public  WebElement nameID;

    @FindBy(linkText = "Logout")
    public WebElement logout;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok;

    @FindBy(name = "car")
    public WebElement carselect;

    @FindBy(name = "pickUpLocation")
    public WebElement pickUpLoc;

    @FindBy(name = "dropOfLocation")
    public WebElement dropOffLoc;

    @FindBy(name = "pickUpDate")
    public WebElement getPickUpDate;

    @FindBy(name = "pickUpTime")
    public WebElement getPickUpTime;

    @FindBy(name = "dropOffDate")
    public WebElement getDropOffDate;

    @FindBy(name = "dropOffTime")
    public WebElement getDropOffTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;


}
