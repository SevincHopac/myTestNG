package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day09_ListenersTest03 {

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1() {
        System.out.println("Test01-Pass");
        Assert.assertTrue(true);
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test2() {
        System.out.println("Test02-Fail");
        Assert.assertTrue(false);
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test3() {
        System.out.println("Test03-Skip");
        throw new SkipException("Metodu skip ettik bilerek");
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test4() {
        System.out.println("Test4-Exception");
        //  throw new NoSuchElementException("NoSuchElementExcp.");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));
    }
}
