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

public class Day04_NegativeLoginTest02 {

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();


    @Test
    public void US101122_Negative_Login() {

        //Description:
        //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
        //Acceptance Criteria:
        //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
        //Error Message: email must be a valid email
        //Dogru email uzantisi girildiğinde hata mesajı alınmamalı
        //https://email-verify.my-addr.com/list-of-most-popular-email-domains.php

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));
        ReusableMethods.waitFor(4);
        blueRentCarHomePage.loginButton.click();
        blueRentCarLoginPage.mail.sendKeys(ConfigReader.getProperty("invalid_mail"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        String message = wait.until(ExpectedConditions.visibilityOf(blueRentCarLoginPage.mailMes)).getText();
        Assert.assertEquals(message, "email must be a valid email");
        blueRentCarLoginPage.mail.sendKeys(ConfigReader.getProperty("bluerent_email"));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(blueRentCarLoginPage.mailMes)));

    }



}
