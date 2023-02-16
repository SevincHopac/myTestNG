package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HubcomfyHomePage {

    public HubcomfyHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement register;

    @FindBy(xpath = "//input[@autocomplete='email'][1]")
    public WebElement regMail;

    @FindBy(xpath = "//input[@id='reg_username'][1]")
    public WebElement regUserName;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement regPass;

    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement regIAgree;

    @FindBy(xpath = "//button[@name=\"register\"]")
    public WebElement signUpButton;


}
