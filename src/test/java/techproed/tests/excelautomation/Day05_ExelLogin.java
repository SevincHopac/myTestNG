package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.*;


public class Day05_ExelLogin {

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();
    ExcelUtils excelUtils;

    List<Map<String, String>> excelData;


    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));


        //               ------SADECE ILK GIRIS-------
//        loginLink butonu sadece ilk giriste sayfada gorunur
//        Ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NoSuchElementException alinir
//        Biz bu exception'i try-catch kullanarak yakalariz ve test case calismaya devam eder


        try {
            blueRentCarHomePage.loginButton.click();
            ReusableMethods.waitFor(1);

        } catch (Exception e) {
        }

        //    sonraki login-logout islemleri

        try {
            blueRentCarHomePage.nameID.click();
            ReusableMethods.waitFor(2);
            blueRentCarHomePage.logout.click();
            ReusableMethods.waitFor(2);
            blueRentCarHomePage.ok.click();
            ReusableMethods.waitFor(2);
            blueRentCarHomePage.loginButton.click();

        } catch (Exception e) {
        }

    }


    @Test
    public void customerLogin() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";   //   Basindaki './' onceki tüm dosyalari icer.RELATIVE PATH
        String sheet = "customer_info";
        excelUtils = new ExcelUtils(path, sheet);
        excelData = excelUtils.getDataList();

        for (Map<String, String> data : excelData) {

            login();

            ReusableMethods.waitFor(2);
            blueRentCarLoginPage.mail.sendKeys(data.get("username"));
            ReusableMethods.waitFor(2);
            blueRentCarLoginPage.password.sendKeys(data.get("password"));
            ReusableMethods.waitFor(2);
            blueRentCarLoginPage.submit.click();
            ReusableMethods.waitFor(2);

            // successfully login Assert
            ReusableMethods.verifyElementDisplayed(blueRentCarHomePage.nameID);
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshot("Screenshot");

        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }



    /*
sam.walker@bluerentalcars.com   c!fas_art
kate.brown@bluerentalcars.com   tad1$Fas
raj.khan@bluerentalcars.com v7Hg_va^
pam.raymond@bluerentalcars.com  Nga^g6!

------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
 */
}
