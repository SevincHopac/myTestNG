package techproed.tests.day123;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import techproed.pages.PearlyHome;

import techproed.pages.PearlyProductManage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;



public class PearlyTest {

    PearlyProductManage productManage = new PearlyProductManage();
    PearlyHome home = new PearlyHome();

    @Test
    public void test02() {
        PearlyHome.loginAsVendor();
        Driver.getDriver().get("https://pearlymarket.com/store-manager/products-manage/");
        productManage.picture1.click();
        ReusableMethods.waitFor(3);
        productManage.mediaLibrary.click();
        productManage.macbookpro2.click();
        ReusableMethods.waitFor(3);
        productManage.selectButton.click();
        ReusableMethods.scrollIntoViewJS(productManage.attributes);
        ReusableMethods.clickByJS(productManage.attributes);
        ReusableMethods.clickByJS(productManage.colorCheckBox);
        ReusableMethods.clickByJS(productManage.colorInput);
        ReusableMethods.JSExecutorSelectVisibleText(productManage.selectText,"Black");


    }
}
