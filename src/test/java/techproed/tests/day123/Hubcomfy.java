package techproed.tests.day123;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.HubcomfyHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Hubcomfy {

    HubcomfyHomePage hubcomfyHomePage = new HubcomfyHomePage();

    @Test
    public void registerTest() {

        Driver.getDriver().get(ConfigReader.getProperty("mail"));
        ReusableMethods.waitFor(3);
        hubcomfyHomePage.register.click();
        hubcomfyHomePage.regUserName.sendKeys(Faker.instance().name().firstName());
        hubcomfyHomePage.regMail.sendKeys(Faker.instance().internet().emailAddress());
        hubcomfyHomePage.regPass.sendKeys(Faker.instance().internet().password());
        hubcomfyHomePage.regIAgree.click();
        hubcomfyHomePage.signUpButton.submit();

    }
}
