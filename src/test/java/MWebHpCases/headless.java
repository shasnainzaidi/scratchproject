package MWebHpCases;

import HomeObj.Objects;
import HomeObj.homepageObj;
import HpCases.testNGListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@Listeners(testNGListeners.class)
public class headless {


    private WebDriver driver;
    private Objects headles;
    private homepageObj home;

   @BeforeTest
   public void initialization(){

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();

   }

   @Test(description= "Upload image from computer")

    public void login() throws IOException {
       headles = new Objects(driver);
       home = new homepageObj(driver);
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
        home.chatButton.click();
        home.firstChat.click();
        home.clickAttachment.click();
        home.clickGallery.click();
        Runtime.getRuntime().exec("D:\\AutoITChat.exe");


   }



}
