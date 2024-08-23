package HomeObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepageObj {

    public WebDriver driver;
    @FindBy(css = "input[placeholder='Location or Compound']")
    public WebElement l1Location;

    @FindBy(xpath = "//span[normalize-space()='Punjab, Pakistan']")
    public WebElement l2Location;

    @FindBy(xpath = "(//span[contains(text(),'Lahore, Punjab')])[1]")
    public WebElement l3Location;

    @FindBy(xpath = "//span[normalize-space()='Aabpara Coop Housing Society, Lahore']")
    public WebElement l4Location;

    @FindBy(xpath = "(//div[@class='_9dfeb3c2'])[63]")
    public WebElement firstAd;

    @FindBy(css = "._1ee53078")
    public WebElement adLocation;


    @FindBy(css ="div[aria-label='Location input'] div div[class='_1db27fa0']")
    public WebElement homeLocation;

    @FindBy(xpath = "//img[@alt='Go to chat']")
    public WebElement chatButton;

    @FindBy(xpath = "//a[@class='_8b393b43']")
    public WebElement firstChat;

    @FindBy(xpath = "//button[@class='c70b4ce7 _3b9a59f0']//*[name()='svg']")
    public WebElement clickAttachment;

    @FindBy(xpath = "//label[1]//*[name()='svg']")
    public WebElement clickGallery;

    @FindBy(css = ".ce4a27bf")
    public WebElement back2Top;

    @FindBy(css = "._11996820")
    public WebElement searchButton;

    @FindBy(css = "._7c57f8f7")
    public WebElement searchTitle;



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

    private String[] link3XPaths = {
            "(//span[@class='_1fcb6673'])[9]",  // Link 1
            "(//span[@class='_1fcb6673'])[10]",  // Link 2
            "(//span[@class='_1fcb6673'])[11]",  // Link 3
            "(//span[@class='_1fcb6673'])[12]"   // Link 4
    };
    private String[] expectedTitles3 = {
            "Dubizzle Group – Formerly EMPG",  // Expected title for Link 1
            "Homepage | OLX Blog", // Expected title for Link 2
            "How can you contact Us? – OLX PK",// Expected title for Link 3
            "OLX For Business"  // Expected title for Link 4
    };


    private String[] link4XPaths = {
            "(//span[@class='_1fcb6673'])[13]",  // Link 1
            "(//span[@class='_1fcb6673'])[14]",  // Link 2
            "(//span[@class='_1fcb6673'])[15]",  // Link 3
            "(//span[@class='_1fcb6673'])[16]"   // Link 4
    };
    private String[] expectedTitles4 = {
            "OLX PK",  // Expected title for Link 1
            "Sitemap Most Popular", // Expected title for Link 2
            "What are the terms of use? – OLX PK",// Expected title for Link 3
            "Legal & Privacy information – OLX PK"  // Expected title for Link 4
    };
    private String prodURL = "https://www.olx.com.pk/";

    public void openURL(){
        driver.get(prodURL);
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
    public String[] getLink3XPaths() {
        return link3XPaths;
    }

    // Method to return expected titles
    public String[] getExpectedTitles3() {
        return expectedTitles3;
    }
    public String[] getLink4XPaths() {
        return link4XPaths;
    }

    // Method to return expected titles
    public String[] getExpectedTitles4() {
        return expectedTitles4;
    }

}
