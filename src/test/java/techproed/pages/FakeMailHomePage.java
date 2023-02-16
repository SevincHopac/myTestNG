package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FakeMailHomePage {

    public FakeMailHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//a[@title='Copy this email address'])[2]")
    public WebElement mailCopy;

    @FindBy(xpath = "//a[@title='Copy this password']")
    public WebElement passCopy;


}
