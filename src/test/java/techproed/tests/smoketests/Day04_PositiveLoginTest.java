package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Day04_PositiveLoginTest {

/*    Name: US100201_Admin_Login

    Description: Admin bilgileriyle giriş

    Acceptance Criteria:

    Admin olarak, uygulamaya giriş yapabilmeliyim
    https://www.bluerentalcars.com/
    Admin email: jack@gmail.com
    Admin password: 12345*/

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();


    @Test
    public void US100201_Admin_Login() throws InterruptedException {

        Reporter.log("Sayfaya git");

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));
        blueRentCarHomePage.loginButton.click();
        Reporter.log("Giris bilgilerini gir");
        blueRentCarLoginPage.mail.sendKeys(ConfigReader.getProperty("bluerent_email"));
        blueRentCarLoginPage.password.sendKeys(ConfigReader.getProperty("bluerent_password"));
        blueRentCarLoginPage.submit.click();

        Assert.assertTrue(blueRentCarHomePage.loginButton.isDisplayed());
        Driver.closeDriver();
    }

}
