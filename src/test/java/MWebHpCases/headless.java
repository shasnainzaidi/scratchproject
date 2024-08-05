package MWebHpCases;

import HomeObj.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class headless {


    private WebDriver driver;
    private Objects headles;

   @BeforeTest
   public void initialization(){

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(options);

   }

   @Test
    public void login(){
       headles = new Objects(driver);
       headles.openURL();
       headles.LoginBtn.click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );    //3. click on continue with email
       headles.LoginEmail.click();

       //4. Enter email
       headles.enteremail();

       //5. Enter password
       headles.enterPassword();    //click login
       headles.Login.click();
       // @Description(" Assert if user has logged in or not")
       headles.userDropdown.click();
       WebElement userNameElement = headles.userNameElement;
       String userName = userNameElement.getText();
       System.out.println(userName);
       String expected= "Everything for “U”";
       Assert.assertEquals(userName, expected);
       driver.close();


   }

}
