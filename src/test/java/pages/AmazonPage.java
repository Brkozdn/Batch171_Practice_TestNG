package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {



    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;



    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaMotoru;



    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun;










    // C02_DataProvider locateleri


    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;






}
