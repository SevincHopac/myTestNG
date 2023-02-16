package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;


public class DiligentLibrariesLoginPage {

    public DiligentLibrariesLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailBox;

    @FindBy(xpath = "(//*[@name='password'])[1]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement loginButton;


}

