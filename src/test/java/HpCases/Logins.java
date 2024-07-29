package HpCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import HomeObj.Objects;


import java.util.concurrent.TimeUnit;

public class Logins{
    private WebDriver driver;
    private Objects loginobj;

    @BeforeMethod
    public void Initialization() {
        String chromeVersion = "126.0.6478.183";
        WebDriverManager.chromedriver().driverVersion(chromeVersion).setup();
        driver = new ChromeDriver();

    }



@Test (groups ="Sanity")
    public void loginEmail(){
    loginobj = new Objects(driver);

//1. Open website
    loginobj.openURL();
    //2. click on login button
loginobj.LoginBtn.click();
    System.out.println("login button clicked");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
//3. click on continue with email
loginobj.LoginEmail.click();
    System.out.println("Click on login with email");

    //4. Enter email
loginobj.enteremail();
    System.out.println("Email ID is entered");

    //5. Enter password

loginobj.enterPassword();
    System.out.println("password is entered");
    //click login
loginobj.Login.click();
    System.out.println("Login button is clicked");
   // @Description(" Assert if user has logged in or not")
    driver.findElement(By.xpath("//img[@class='_42021e4e']")).click();
            WebElement userNameElement = driver.findElement(By.xpath("//span[@class='_2454243d b7af14b4']"));
    String userName = userNameElement.getText();
            System.out.println(userName);
             String expected= "Everything for “U”";
    Assert.assertEquals(userName, expected);
    System.out.println("Assertion is passed");
   //3. Close the browser
    System.out.println("exiting the browser");

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test (groups ="Sanity")
    public void loginPhone(){
        System.out.println("Starting phone login test");
    loginobj = new Objects(driver);
    System.out.println("Object class imported");
    //driver.get("https://www.olx.com.pk/");

    loginobj.openURL();
    System.out.println("browser opened");

    loginobj.LoginBtn.click();
    System.out.println("Clicked login button");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
    System.out.println("wait done");

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

@Test
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
