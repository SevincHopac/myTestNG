package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day06_DataProvider2 {



    @DataProvider
    public Object[][] customerData(){
        Object[][] customerInfo={
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^" },
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return customerInfo;
    }

    BlueRentCarLoginPage blueRentCarLoginPage;
    BlueRentCarHomePage blueRentCarHomePage;

    @Test(dataProvider = "customerData")
    public void dataProviderTest(String mail,String pass) {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));

        blueRentCarHomePage = new BlueRentCarHomePage();
        blueRentCarLoginPage = new BlueRentCarLoginPage();

        blueRentCarHomePage.loginButton.click();
        ReusableMethods.waitFor(1);
        blueRentCarLoginPage.mail.sendKeys(mail);
        ReusableMethods.waitFor(1);
        blueRentCarLoginPage.password.sendKeys(pass);
        ReusableMethods.waitFor(1);
        blueRentCarLoginPage.submit.click();
        ReusableMethods.waitFor(1);
        blueRentCarHomePage.nameID.click();
        ReusableMethods.waitFor(1);
        blueRentCarHomePage.logout.click();
        ReusableMethods.waitFor(1);
        blueRentCarHomePage.ok.click();

        Driver.closeDriver();

    }

}
