package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class PearlyHome {

    static PearlyHome pearlyHome = new PearlyHome();

    public PearlyHome(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signIn;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement submit;
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;


    public static void loginAsVendor() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        pearlyHome.signIn.click();
        pearlyHome.username.sendKeys(ConfigReader.getProperty("mail"));
        pearlyHome.password.sendKeys(ConfigReader.getProperty("pearlypassword"));
        pearlyHome.submit.submit();
        ReusableMethods.waitFor(5);
    }
}
