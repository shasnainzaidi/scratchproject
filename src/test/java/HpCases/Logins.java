package HpCases;

import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import HomeObj.Objects;


import java.util.concurrent.TimeUnit;
@Listeners(testNGListeners.class)
public class Logins{
    private WebDriver driver;
    private Objects loginobj;
    private concepts.configReader configReader;


    @BeforeMethod
    public WebDriver Initialization() {
        configReader = new configReader();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        String chromeVersion = configReader.getProperty("chromevers");
        WebDriverManager.chromedriver().driverVersion(chromeVersion).setup();
        driver = new ChromeDriver();
        return driver;

    }



@Test (groups ="Sanity", priority = 1)
    public void loginEmail(){
    loginobj = new Objects(driver);
    int timeout = Integer.parseInt(configReader.getProperty("timeout"));


//1. Open website
    loginobj.openURL();
    //2. click on login button
loginobj.LoginBtn.click();
driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );
//3. click on continue with email
loginobj.LoginEmail.click();

    //4. Enter email
loginobj.enteremail();
 //5. Enter password
loginobj.enterPassword();
    //click login
loginobj.Login.click();
   // @Description(" Assert if user has logged in or not")
loginobj.userDropdown.click();
WebElement userNameElement = loginobj.userNameElement;
    String userName = userNameElement.getText();
            System.out.println(userName);
             String expected= "Everything for “U”";
    Assert.assertEquals(userName, expected);

   //3. Close the browser

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test (groups ="Sanity", priority = 2)
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
    public void emailValidation(){
        //1. Imported the POM object class as driver
       try {
           loginobj = new Objects(driver);
           //2. Opened base url
           loginobj.openURL();
           //3. Timeout
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           //4. Click on login button
           loginobj.LoginBtn.click();
           //5. Click on login with email
           loginobj.LoginEmail.click();
           //6. Enter email
           loginobj.enterInvalidEmail();
           //7. Navigate to password
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

        //Assertion


       }


}



}
