package tests.day02;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegatifLoginDataProvider {
    @DataProvider
    public static Object[][] kullaniciBilgisi() {
        return new Object[][]{{"ali@gmail.com","123456"},
                              {"veli@gmail.com","654321"},
                              {"hasan@gmail.com","963258"}};
    }


    // https://id.heroku.com/login sayfasına gidin

    // yanlıs email ve yanlıs password giriniz
    // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

    // login butonuna tıklayınız

    // "There was a problem with your login." yazisinin gorunur oldugunu test edin

    // sayfayı kapatınız


    @Test(dataProvider = "kullaniciBilgisi")
    public void test01(String email,String password) {


        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));



        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

        HerokuapPage herokuapPage = new HerokuapPage();

        herokuapPage.email.sendKeys(email);
        herokuapPage.passwordKutusu.sendKeys(password);



        // login butonuna tıklayınız
        herokuapPage.login.click();

        // "There was a problem with your login." yazisinin gorunur oldugunu test edin
        Assert.assertTrue(herokuapPage.theWasaProblemYaziElementi.isDisplayed());
        // sayfayı kapatınız
        Driver.closeDriver();

    }
}
