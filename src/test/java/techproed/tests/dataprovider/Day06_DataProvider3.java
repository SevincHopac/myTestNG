package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day06_DataProvider3 {

    @DataProvider
    public Object[][] excel(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        ExcelUtils excelUtils= new ExcelUtils(path,sheetName);
        Object excelData[][]= excelUtils.getDataArrayWithoutFirstRow();

        return excelData;
    }
    @Test(dataProvider = "excel")
    public void testLogin(String mail,String password) throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));

        BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();
        BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();

        blueRentCarHomePage.loginButton.click();
        blueRentCarLoginPage.mail.sendKeys(mail);
        blueRentCarLoginPage.password.sendKeys(password);
        blueRentCarLoginPage.submit.click();
        ReusableMethods.waitFor(2);

        blueRentCarHomePage.nameID.click();
        ReusableMethods.waitFor(2);

        ReusableMethods.verifyElementDisplayed(blueRentCarHomePage.nameID);
        ReusableMethods.getScreenshot("Screenshots");
        blueRentCarHomePage.logout.click();
        ReusableMethods.waitFor(2);

        blueRentCarHomePage.ok.click();
        ReusableMethods.waitFor(2);

        Driver.closeDriver();



    }
}
