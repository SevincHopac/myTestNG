package techproed.tests.day123;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproLoginPage;
import techproed.pages.TechproSecureArea;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day03_TechproLogin {


    @Test(groups = "regression-tests")
    public void test() throws InterruptedException {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        //Sayfadan cikis yap, cikis yapildigini verify et

        Driver.getDriver().get(ConfigReader.getProperty("techtest_url"));

        TechproLoginPage techproLoginPage = new TechproLoginPage();

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techtest_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techtest_password"));
        techproLoginPage.submit.click();

        Thread.sleep(5000);
        TechproSecureArea techproSecureArea = new TechproSecureArea();
        Assert.assertTrue(techproSecureArea.text.isDisplayed());

        techproSecureArea.logout.click();
        Assert.assertTrue(techproLoginPage.username.isDisplayed());

        Driver.closeDriver();
    }
}
