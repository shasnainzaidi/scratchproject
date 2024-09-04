package hpcases;

import concepts.configReader;
import objects.Objects;
import objects.homepageObj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

//@Listeners(testNGListeners.class)
public class chat extends Logins{

    private static final Logger log = LoggerFactory.getLogger(chat.class);
    private concepts.configReader configReader;
    private homepageObj home;

   @BeforeMethod(alwaysRun = true)
   public void setupPage(){
       home = new homepageObj(driver);
       configReader = new configReader();
   }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

   @Test(description= "send chat image from computer")
    public void chatImage() {
        loginEmail();
       System.out.println("Login done");

       int timeout = Integer.parseInt(configReader.getProperty("timeout"));
          home.chatButton.click();
        home.firstChat.click();
        home.clickAttachment.click();
        home.clickGallery.click();
       try {
           Runtime.getRuntime().exec("D:/AutoITimage.exe");
       } catch (IOException e) {
           e.printStackTrace();
       }


   }



}
