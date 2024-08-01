package HomeObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepageObj {

    public WebDriver driver;
    @FindBy(xpath = "//input[@autocomplete='location-search']")
    public WebElement l1Location;

    @FindBy(xpath = "(//span[@class='_8206696c'])[8]")
    public WebElement l2Location;

    @FindBy(xpath = "(//span[@class='_8206696c'])[3]")
    public WebElement l3Location;

    @FindBy(xpath = "(//div[@class='_9dfeb3c2'])[63]")
    public WebElement firstAd;

    @FindBy(xpath = "//div[@class='_1ee53078']")
    public WebElement adLocation;


    @FindBy(xpath ="(//input[@class='_0c2ffce3'])[1]")
    public WebElement homeLocation;



    private String baseURL = "https://www.olx.com.pk/";

    public void openURL(){
        driver.get(baseURL);
    }






    public homepageObj (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
