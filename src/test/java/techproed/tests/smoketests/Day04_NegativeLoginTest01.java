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

public class Day04_NegativeLoginTest01 {

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();



    @Test  // (invocationCount = 5)  tekrar say. driver close olmamali
    public void US100208_Negative_Login() {
        //User should not be able login with incorrect credentials
        //Acceptance Criteria:
        //As customer, I should not be able to log in the application
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error: User with email fake@bluerentalcars.com not found

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));
        ReusableMethods.waitFor(2);
        blueRentCarHomePage.loginButton.click();
        blueRentCarLoginPage.mail.sendKeys(ConfigReader.getProperty("fakeemail"));
        blueRentCarLoginPage.password.sendKeys(ConfigReader.getProperty("fakepassword"));
        blueRentCarLoginPage.submit.click();

        Assert.assertEquals(popupMessage(),"User with email fake@bluerentalcars.com not found");

    }

    public  String popupMessage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(blueRentCarLoginPage.popupMessage)).getText();
    }
}
