package techproed.tests.smoketests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class Day04_NegativeLoginTest03 {

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();



    @Test
    public void US100402_Negative_Login() {

        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
        //Acceptance Criteria:
        //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
        //Hata Mesaji:
        //Bad credentials
        //Test Data:
        //Customer email: jack@gmail.com
        //Customer password: fakepas

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));
        ReusableMethods.waitFor(3);
        blueRentCarHomePage.loginButton.click();
        blueRentCarLoginPage.mail.sendKeys(ConfigReader.getProperty("bluerent_email"));
        blueRentCarLoginPage.password.sendKeys(ConfigReader.getProperty("fakepassword"));
        blueRentCarLoginPage.submit.click();

        Assert.assertEquals(popupMessage(),"Bad credentials");

    }

    public  String popupMessage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(blueRentCarLoginPage.popupMessage)).getText();
    }
}
