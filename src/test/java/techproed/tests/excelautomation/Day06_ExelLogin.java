package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;
import java.util.*;


public class Day06_ExelLogin {

    BlueRentCarHomePage blueRentCarHomePage;
    BlueRentCarLoginPage blueRentCarLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    @Test
    public void customerLogin() {

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa = "customer_info";

        excelUtils = new ExcelUtils(path, sayfa);
        excelDatalari = excelUtils.getDataList();

        for (Map<String, String> data : excelDatalari) {

            Driver.getDriver().get(ConfigReader.getProperty("blueRentCarLoginPage"));
            blueRentCarHomePage = new BlueRentCarHomePage();
            blueRentCarLoginPage = new BlueRentCarLoginPage();
            blueRentCarHomePage.loginButton.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            ReusableMethods.waitFor(1);
            blueRentCarLoginPage.mail.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentCarLoginPage.password.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            blueRentCarLoginPage.submit.click();
            ReusableMethods.waitFor(1);
            blueRentCarHomePage.nameID.click();
            ReusableMethods.waitFor(1);
            blueRentCarHomePage.logout.click();
            ReusableMethods.waitFor(1);
            blueRentCarHomePage.ok.click();
        }

        Driver.closeDriver();
    }

}
