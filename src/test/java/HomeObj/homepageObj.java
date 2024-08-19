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

    @FindBy(xpath = "//img[@alt='Go to chat']")
    public WebElement chatButton;

    @FindBy(xpath = "//a[@class='_8b393b43']")
    public WebElement firstChat;

    @FindBy(xpath = "//button[@class='c70b4ce7 _3b9a59f0']//*[name()='svg']")
    public WebElement clickAttachment;

    @FindBy(xpath = "//label[1]//*[name()='svg']")
    public WebElement clickGallery;


    private String[] linkXPaths = {
            "(//span[@class='_1fcb6673'])[1]",  // Link 1
            "(//span[@class='_1fcb6673'])[2]",  // Link 2
            "(//span[@class='_1fcb6673'])[3]",  // Link 3
            "(//span[@class='_1fcb6673'])[4]"   // Link 4
    };
    private String[] expectedTitles = {
            "Cars for Sale in Pakistan",  // Expected title for Link 1
            "Apartments for Rent in Pakistan | Flats for Rent in Pakistan", // Expected title for Link 2
            "Mobile Phones for Sale in Pakistan | Mobile Phone Prices in Pakistan",// Expected title for Link 3
            "Jobs in Pakistan"  // Expected title for Link 4
    };
    private String[] link2XPaths = {
            "(//span[@class='_1fcb6673'])[5]",  // Link 1
            "(//span[@class='_1fcb6673'])[6]",  // Link 2
            "(//span[@class='_1fcb6673'])[7]",  // Link 3
            "(//span[@class='_1fcb6673'])[8]"   // Link 4
    };
    private String[] expectedTitles2 = {
            "Motorcycles for Sale in Pakistan | Motorcycle Prices in Pakistan",  // Expected title for Link 1
            "Watches for Sale in Pakistan | Watches Prices in Pakistan", // Expected title for Link 2
            "Books Price in Pakistan | Books for Sale in Pakistan",// Expected title for Link 3
            "Dogs for Sale in Pakistan | Dog Prices in Pakistan"  // Expected title for Link 4
    };

    private String baseURL = "https://www.olx.com.pk/";

    public void openURL(){
        driver.get(baseURL);
    }






    public homepageObj (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Method to return link XPaths
    public String[] getLinkXPaths() {
        return linkXPaths;
    }

    // Method to return expected titles
    public String[] getExpectedTitles() {
        return expectedTitles;
    }
    public String[] getLink2XPaths() {
        return link2XPaths;
    }

    // Method to return expected titles
    public String[] getExpectedTitles2() {
        return expectedTitles2;
    }
}
