package tests.day02;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
    }


    // amazon sayfasına gidelim
    // Nutella, Java, cigdem ve Netherlands icin arama yapalım
    // sonuc yazısının aradıgımız kelimeyi icerdigini test edelim
    // sayfayı kapatalım


    @Test(dataProvider = "aranacakKelimeler")
    public void test01(String arananKelime) {

        // amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, cigdem ve Netherlands icin arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaMotoru.sendKeys(arananKelime + Keys.ENTER);



        // sonuc yazısının aradıgımız kelimeyi icerdigini test edelim

        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains(arananKelime));


        // sayfayı kapatalım
        Driver.closeDriver();

    }
}
