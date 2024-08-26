package HomeObj;

import io.qameta.allure.Step;
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
            "//span[@class='_1fcb6673'][normalize-space()='Cars']",  // Link 1
            "//span[normalize-space()='Flats for rent']",  // Link 2
            "//span[@class='_1fcb6673'][normalize-space()='Mobile Phones']",  // Link 3
            "//span[@class='_1fcb6673'][normalize-space()='Jobs']"   // Link 4
    };
    private String[] expectedTitles = {
            "Cars for Sale in Pakistan",  // Expected title for Link 1
            "Apartments for Rent in Pakistan | Flats for Rent in Pakistan", // Expected title for Link 2
            "Mobile Phones for Sale in Pakistan | Mobile Phone Prices in Pakistan",// Expected title for Link 3
            "Jobs in Pakistan"  // Expected title for Link 4
    };
    private String[] link2XPaths = {
            "//span[@class='_1fcb6673'][normalize-space()='Bikes']",  // Link 1
            "//span[normalize-space()='Watches']",  // Link 2
            "//span[normalize-space()='Books']",  // Link 3
            "//span[normalize-space()='Dogs']"   // Link 4
    };
    private String[] expectedTitles2 = {
            "Motorcycles for Sale in Pakistan | Motorcycle Prices in Pakistan",  // Expected title for Link 1
            "Watches for Sale in Pakistan | Watches Prices in Pakistan", // Expected title for Link 2
            "Books Price in Pakistan | Books for Sale in Pakistan",// Expected title for Link 3
            "Dogs for Sale in Pakistan | Dog Prices in Pakistan"  // Expected title for Link 4
    };

    private String[] link3XPaths = {
            "//span[normalize-space()='About Dubizzle Group']",  // Link 1
            "//span[normalize-space()='OLX Blog']",  // Link 2
            "//span[normalize-space()='Contact Us']",  // Link 3
            "//span[normalize-space()='OLX for Businesses']"   // Link 4
    };
    private String[] expectedTitles3 = {
            "Dubizzle Group – Formerly EMPG",  // Expected title for Link 1
            "Homepage | OLX Blog", // Expected title for Link 2
            "How can you contact Us? – OLX PK",// Expected title for Link 3
            "OLX For Business"  // Expected title for Link 4
    };
    private String[] expectedURL3 = {
            "https://www.dubizzlegroup.com/",  // Expected URL for Link 1
            "https://blog.olx.com.pk/", // Expected URL for Link 2
            "https://help.olx.com.pk/hc/en-us/articles/4403042207631-How-can-you-contact-Us-",// Expected title for Link 3
            "https://www.surveygizmo.com/s3/4910980/WP-Business-Form?source=Website"  // Expected title for Link 4
    };


    private String[] link4XPaths = {
            "//span[normalize-space()='Help']",  // Link 1
            "//span[normalize-space()='Sitemap']",  // Link 2
            "//span[normalize-space()='Terms of use']",  // Link 3
            "//span[normalize-space()='Privacy Policy']"   // Link 4
    };
    private String[] expectedTitles4 = {
            "OLX PK",  // Expected title for Link 1
            "Sitemap Most Popular", // Expected title for Link 2
            "What are the terms of use? – OLX PK",// Expected title for Link 3
            "Legal & Privacy information – OLX PK"  // Expected title for Link 4
    };
    private String[] expectedURL4 = {
            "https://help.olx.com.pk/hc/en-us",  // Expected title for Link 1
            "https://www.olx.com.pk/sitemap/most-popular", // Expected title for Link 2
            "https://help.olx.com.pk/hc/en-us/articles/4402989977487-What-are-the-terms-of-use-",// Expected title for Link 3
            "https://help.olx.com.pk/hc/en-us/categories/4402989237007-Legal-Privacy-information"  // Expected title for Link 4
    };
    private String prodURL = "https://www.olx.com.pk/";

   @Step("Open URL")
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
    public String[] getExpectedURL3() {
        return expectedURL3;
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
        return expectedTitles4;}

        public String[] getExpectedURL4() {
            return expectedURL4;
        }



}
