package objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Objects {
    public WebDriver driver;
    @FindBy(xpath = "//span[@class='a1c1940e b7af14b4']")
    public WebElement LoginBtn;

    @FindBy(xpath = "//span[normalize-space()='Login with Email']")
    public WebElement LoginEmail;

    @FindBy(xpath = "//span[normalize-space()='Login with Phone']")
    public WebElement LoginPhone;

    @FindBy(xpath = "//button[@class='_91e21052 e07f63ca']")
    public WebElement Login;
    @FindBy(xpath = "//input[@class='_0c2ffce3 _724f8860']")
    public WebElement emailId;

    @FindBy(xpath = "//input[@class='_0c2ffce3 _16f994ea _724f8860']")
    public WebElement phoneId;

    @FindBy(css = "img[alt='User profile dropdown arrow']")
    public WebElement userDropdown;

    @FindBy(xpath = "//span[@class='_2454243d b7af14b4']")
    public WebElement userNameElement;

    @FindBy(xpath = "//span[@aria-label='Input error message'])[1]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//span[normalize-space()='Sell']")
    public WebElement sellBtn;

    @FindBy(xpath = "//span[normalize-space()='Mobiles']")
    public WebElement selectCategory;

    @FindBy(xpath = "//div[contains(text(),'Mobile Phones')]")
    public WebElement selectSubCategory;

    @FindBy(css = "._06fac551")
    public WebElement imageAddBtn;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='make']")
    public WebElement makeOption;

    @FindBy(xpath = "//div[normalize-space()='Acer']")
    public WebElement makeSelection;

    @FindBy(xpath = "//input[@id='new_used']")
    public WebElement conditionOption;

    @FindBy(xpath = "//div[normalize-space()='Open Box']")
    public WebElement conditionSelection;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement adTitle;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement adDescription;

    @FindBy(xpath = "//input[@id='Location']")
    public WebElement adLocation;

    @FindBy(xpath = "//span[normalize-space()='Use current location']")
    public WebElement locationSelection;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement adPrice;

    @FindBy(xpath = "//img[@alt='Remove']")
    public WebElement imageRemoveBtn;


    @Step("Entering text into the input field")
    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    @Step("Opening the Website")
    public void openURL() {
        driver.get("https://www.olx.com.pk/");
    }

    @Step("Entering the invalid email")
    public void enterInvalidEmail() {
        enterText(emailId, "hasnin.xaidi1@gmail.com");
    }

    @Step("Entering the phone number")
    public void enterPhone() {
        enterText(phoneId, "03434001699");
    }

    @Step("Entering the Email ID")
    public void enteremail(){
        enterText(emailId, "hasnain.xaidi1@gmail.com");
    }

    @Step("Added Title for the Ad")
    public void addTitle() {
        enterText(adTitle, "Mobile for sale in Lahore");
    }

    @Step("Added desciprtion for the Ad")
    public void adddescription() {
        enterText(adDescription, "Mobile for sale in LahoreMobile for sale in Lahore");
    }

    public void enterEmail(String email) {
        emailId.clear();
        emailId.sendKeys(email);
    }


    @Step("Added ad price")
    public void addprice() {
        enterText(adPrice, "5000");
    }

    @Step("Entering the password and click next")
    public void enterPassword() {
        enterText(password, "qwerty10@");
    }

    public Objects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
