package techproed.tests.dataprovider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DiligentLibrariesHomePage;
import techproed.pages.DiligentLibrariesLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class DiligentLogin {

    DiligentLibrariesLoginPage diligentLibrariesLoginPage;
    DiligentLibrariesHomePage diligentLibrariesHomePage;

    @DataProvider
    public Object[][] libraryData() {
        Object[][] userData = {
                {"deneme@mail.com", "Sifre?1"},
                {"sevinckurtgozlu@gmail.com", "1234QWERasdf!"},
                {"deneme@gmail.com", "Deneme?1"}
        };
        return userData;
    }


    @Test(dataProvider = "libraryData")

    public void loginLogout(String mail,String pass) throws IOException {
        diligentLibrariesLoginPage = new DiligentLibrariesLoginPage();
        diligentLibrariesHomePage = new DiligentLibrariesHomePage();

        Driver.getDriver().get(ConfigReader.getProperty("diligent_url"));

        diligentLibrariesLoginPage.emailBox.sendKeys(mail);
        diligentLibrariesLoginPage.passwordBox.sendKeys(pass);
        diligentLibrariesLoginPage.loginButton.click();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(diligentLibrariesHomePage.usernameBox.isDisplayed());
        ReusableMethods.getScreenshot("Screenshot");
        ReusableMethods.waitFor(1);

        diligentLibrariesHomePage.usernameBox.click();
        diligentLibrariesHomePage.logout.click();
        diligentLibrariesHomePage.okButton.click();
        ReusableMethods.verifyElementDisplayed(diligentLibrariesHomePage.signInButton);
        Driver.closeDriver();

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
