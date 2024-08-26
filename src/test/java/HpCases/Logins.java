package HpCases;

import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import HomeObj.Objects;


import java.util.concurrent.TimeUnit;
//@Listeners(testNGListeners.class)
@Listeners({AllureTestNg.class})
public class Logins{
    private WebDriver driver;
    private Objects loginobj;
    private concepts.configReader configReader;


    @BeforeMethod
    public void Initialization() {
        configReader = new configReader();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver();

    }



@Test (groups ="Sanity", priority = 1)
  @Description("Verify login with Email")
    public void loginEmail(){
    loginobj = new Objects(driver);
    int timeout = Integer.parseInt(configReader.getProperty("timeout"));


    loginobj.openURL();
loginobj.LoginBtn.click();
driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );
loginobj.LoginEmail.click();

loginobj.enteremail();
loginobj.enterPassword();
loginobj.Login.click();
    try {
        Thread.sleep(1000);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
loginobj.userDropdown.click();
WebElement userNameElement = loginobj.userNameElement;
    String userName = userNameElement.getText();
            System.out.println(userName);
             String expected= "Everything for “U”";
    Assert.assertEquals(userName, expected);

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test (groups ="Sanity", priority = 2)
@Description("Verify login with Phone Number")
    public void loginPhone(){

    loginobj = new Objects(driver);

    loginobj.openURL();


    loginobj.LoginBtn.click();


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

    loginobj.LoginPhone.click();
        loginobj.enterPhone();
        loginobj.enterPassword();
        loginobj.Login.click();

        loginobj.userDropdown.click();
        String expect = "Everything for “U”";
        WebElement userNameElement = loginobj.userNameElement;
        String userName = userNameElement.getText();
        Assert.assertEquals(userName, expect);
        driver.close();

}

@Test(groups = {"Sanity", "Smoke"}, priority = 3)
@Description("Verify Email field validation")
    public void emailValidation(){
       try {
           loginobj = new Objects(driver);
           loginobj.openURL();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           loginobj.LoginBtn.click();

           loginobj.LoginEmail.click();

           loginobj.enterInvalidEmail();

           loginobj.enterPassword();

           loginobj.Login.click();

           String errorMessage = loginobj.emailErrorMessage.getText();
           System.out.println(errorMessage);
           String expectedMessage = "The e-mail address must be in the format of name@domain.com";
           Assert.assertEquals(errorMessage, expectedMessage);
       }
       catch (Exception ecp){

           System.out.println("We are having some error in code");


       }
       finally {
                System.out.println("cant run the test");


       }


}



}
