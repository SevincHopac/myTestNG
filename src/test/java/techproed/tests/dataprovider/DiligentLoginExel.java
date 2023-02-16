package techproed.tests.dataprovider;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DiligentLibrariesHomePage;
import techproed.pages.DiligentLibrariesLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiligentLoginExel {


    DiligentLibrariesLoginPage diligentLibrariesLoginPage;
    DiligentLibrariesHomePage diligentLibrariesHomePage;
    ExcelUtils excelUtils;

    @DataProvider
    public Object[][] libraryData() {

        String path = "./src/test/java/resources/Diligent.xlsx";
        String sheetName = "Sayfa1";

        excelUtils = new ExcelUtils(path,sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();

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
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + ".png";
        File img = diligentLibrariesHomePage.usernameBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(img,new File(target));

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
