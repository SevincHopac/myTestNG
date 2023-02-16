package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day06_DataProvider1 {


    /*
Data Provider Nedir?
***Veri deposudur. Bir cok veriyi Test Caselere loop kullanmadan aktarmak icin kullanilir
***Data provider 2D(2 boyutlu) object return eder
***Data provider TestNG den gelen bir ozellikdir

Data Provider ne icin kullanilir?
***Data provider DDT(Data Driven Testing) icin kullanilir. Birden fazla datayi test caselerde kullanmak icin kullanilir

Data Provider i nasil kullanirsin?
***@DataProvider annotasyonu ile veri havuzu olusturulur.
@Test metotlariaa bu data havuzu dataProvider parametresi ile baglanir.
Data provider da 2 tane parametre vardir:
***name : metot ismini override etmek icin, yani farkli bir isim ile data provider i cagirmak icin kullanir
***parallel : parallel test case ler olusturmak icin kullanilir
 */


    @DataProvider(name = "smokeTestData")
    public Object[][] products() {
        Object productList[][] = {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"volvo"},
                {"toyota"}

        };
        return productList;
    }

    @Test(dataProvider = "smokeTestData")
    public void searchTest(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "smokeTestData")
    public void testGoogle(String cars) {
        Driver.getDriver().get("https://www.google.com");

        Driver.getDriver().findElement(By.xpath("//*[.='Tümünü kabul et']")).click();

        Driver.getDriver().findElement(By.name("q")).sendKeys(cars + Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(cars));
        Driver.closeDriver();
    }
}
