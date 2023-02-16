package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproSecureArea {

    public TechproSecureArea() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
    public WebElement text;

    @FindBy(xpath = "//a[@class='btn btn-dark']")
    public WebElement logout;


}
