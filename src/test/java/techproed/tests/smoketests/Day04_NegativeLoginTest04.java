package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentCarHomePage;
import techproed.pages.BlueRentCarLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Day04_NegativeLoginTest04 {

    BlueRentCarLoginPage blueRentCarLoginPage = new BlueRentCarLoginPage();
    BlueRentCarHomePage blueRentCarHomePage = new BlueRentCarHomePage();



    @Test
    public void US101201_Negative_Login() {
        //Description:
        //Geçerli giriş yapmadan rezervasyon yapamamalı
        //Acceptance Criteria:
        //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        //Ve giris yapilmadiginda
        //Hata mesaji almali : Please first login
        //Giris yapildiginda hata mesaji alınmamalı

        Driver.getDriver().get(ConfigReader.getProperty("blueRentUrl"));
        ReusableMethods.waitFor(3);
        carSelect();


        blueRentCarHomePage.pickUpLoc.sendKeys(Faker.instance(Locale.US).address().cityName());
        blueRentCarHomePage.dropOffLoc.sendKeys(Faker.instance(Locale.US).address().cityName());

        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:'00'");

        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.add(Calendar.HOUR,2);

        blueRentCarHomePage.getPickUpDate.sendKeys(dateTimeFormatter.format(date));
        blueRentCarHomePage.getPickUpTime.sendKeys(simpleDateFormat.format(calendar.getTime()));

        blueRentCarHomePage.getDropOffDate.sendKeys(dateTimeFormatter.format(date.plusWeeks(2)));
        blueRentCarHomePage.getDropOffTime.sendKeys(simpleDateFormat.format(calendar.getTime()));

        blueRentCarHomePage.submit.click();

        Assert.assertEquals(popupMessage(),"Please first login");
        //   Driver.closeDriver();

    }

    private void carSelect() {
        Select option = new Select(blueRentCarHomePage.carselect);
        int size = option.getOptions().size()-1;
        int rnd = (int) (Math.random() * size);
        option.selectByIndex(rnd+1);
    }

    private void carSelect1() {
        Select option = new Select(blueRentCarHomePage.carselect);
        Faker faker = new Faker();
        int rnd = faker.number().numberBetween(1,option.getOptions().size());
        option.selectByIndex(rnd);
    }


    public  String popupMessage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(blueRentCarLoginPage.popupMessage)).getText();
    }

}
