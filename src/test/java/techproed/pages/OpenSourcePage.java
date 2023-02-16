package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    // Bu sinifin tek amaci var page objelerini bu class da buluruz


    //1.Constuctor
    public OpenSourcePage() {

        //        PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek icin kullanilir // bas degeri vermek
//        Bu sekilde Sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;






}
