package techproed.tests.day123;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day03_OpenSourceLogin {



    @Test
    public void openSourceLoginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submit.click();


        Thread.sleep(5000);
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

    }
}
