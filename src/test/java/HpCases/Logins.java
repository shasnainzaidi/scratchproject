package HpCases;

import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import HomeObj.Objects;


import java.util.concurrent.TimeUnit;
//@Listeners(testNGListeners.class)
public class Logins{
    private WebDriver driver;
    private Objects loginobj;
    private concepts.configReader configReader;


    @BeforeMethod
    public void Initialization() {
        String chromeVersion = "126.0.6478.183";
        WebDriverManager.chromedriver().driverVersion(chromeVersion).setup();
        driver = new ChromeDriver();
        configReader = new configReader();
    }



@Test (groups ="Sanity")
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
@Test (groups ="Sanity")
    public void loginPhone(){

    loginobj = new Objects(driver);

    //driver.get("https://www.olx.com.pk/");

    loginobj.openURL();


    loginobj.LoginBtn.click();


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );


    loginobj.LoginPhone.click();
        loginobj.enterPhone();
        loginobj.enterPassword();
        loginobj.Login.click();

        driver.findElement(By.xpath("//img[@class='_42021e4e']")).click();
        String expect = "Everything for “U”";
        WebElement userNameElement = driver.findElement(By.xpath("//span[@class='_2454243d b7af14b4']"));
        String userName = userNameElement.getText();
        Assert.assertEquals(userName, expect);
        driver.close();

}

@Test(groups = {"Sanity", "Smoke"})
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
           loginobj.emailId.sendKeys("hasnin.xaidi1@gmail.com");
           //7. Navigate to password
           loginobj.enterPassword();
           loginobj.Login.click();
           String errorMessage = driver.findElement(By.xpath("(//span[@aria-label='Input error message'])[1]")).getText();
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
