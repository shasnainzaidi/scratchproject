package MWebHpCases;

import HomeObj.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MwebLogins {
    private WebDriver driver;
    private Objects loginobj;

    @BeforeTest
            public void Initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
@Test
    public void loginEmail(){
    loginobj = new Objects(driver);
//1. Open website
    driver.get("https://www.olx.com.pk/");
    //2. click on login button
    loginobj.LoginBtn.click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );    //3. click on continue with email
    loginobj.LoginEmail.click();

    //4. Enter email
loginobj.enteremail();

    //5. Enter password
loginobj.enterPassword();    //click login
loginobj.Login.click();
   // @Description(" Assert if user has logged in or not")
    driver.findElement(By.xpath("//img[@class='_42021e4e']")).click();
            WebElement userNameElement = driver.findElement(By.xpath("//span[@class='_2454243d b7af14b4']"));
    String userName = userNameElement.getText();
            System.out.println(userName);
             String expected= "Everything for “U”";
    Assert.assertEquals(userName, expected);
    driver.close();

}

@Test
    public void loginPhone(){
    loginobj = new Objects(driver);

    driver.get("https://www.olx.com.pk/");
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


}
