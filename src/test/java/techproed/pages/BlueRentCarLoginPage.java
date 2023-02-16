package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentCarLoginPage {

    public BlueRentCarLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(name = "email")
    public WebElement mail;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement popupMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement mailMes;


}
