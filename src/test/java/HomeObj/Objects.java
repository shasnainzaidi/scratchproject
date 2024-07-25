package HomeObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Objects {
    public WebDriver driver;
    @FindBy(xpath = "//span[@class='a1c1940e b7af14b4']")
    public WebElement LoginBtn;

    @FindBy(xpath = "(//span[@class='_30de236c b7af14b4'])[3]")
    public WebElement LoginEmail;

    @FindBy(xpath = "(//span[@class='_30de236c b7af14b4'])[4]")
    public WebElement LoginPhone;

    @FindBy(xpath = "//button[@class='_91e21052 e07f63ca']")
    public WebElement Login;
    @FindBy(xpath = "//input[@class='_0c2ffce3 _724f8860']")
    public WebElement emailId;

    @FindBy(xpath = "//input[@class='_0c2ffce3 _16f994ea _724f8860']")
    public WebElement phoneId;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    private String baseURL = "https://www.olx.com.pk/";

    private String number = "03434001699";
    private String pswrd = "qwerty10@";
    private String email = "hasnain.xaidi1@gmail.com";

    public void openURL() {
        driver.get(baseURL);
    }
    public void enterPhone(){
        phoneId.sendKeys(number);

    }

    public void enteremail(){
        emailId.sendKeys(email);

    }
    public void enterPassword(){
        password.sendKeys(pswrd);

    }
    public Objects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
