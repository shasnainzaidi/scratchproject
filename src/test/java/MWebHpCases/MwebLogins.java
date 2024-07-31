package MWebHpCases;

import HomeObj.Objects;
import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MwebLogins {
    private WebDriver driver;
    private Objects loginobj;
    private Properties properties;
    private configReader configReader;

    @Parameters("browserName")
    @BeforeTest
            public void Initialization(@Optional("chrome") String browserName) {
        configReader = new configReader();
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


    }
@Test (dependsOnMethods = {"loginPhone"})
    public void loginEmail(){
    loginobj = new Objects(driver);
    int timeout = Integer.parseInt(configReader.getProperty("timeout"));
//1. Open website
    loginobj.openURL();
    //2. click on login button
    loginobj.LoginBtn.click();
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );    //3. click on continue with email
    loginobj.LoginEmail.click();

    //4. Enter email
loginobj.enteremail();

    //5. Enter password
loginobj.enterPassword();    //click login
loginobj.Login.click();
   // @Description(" Assert if user has logged in or not")
    loginobj.userDropdown.click();
            WebElement userNameElement = loginobj.userNameElement;
    String userName = userNameElement.getText();
            System.out.println(userName);
             String expected= "Everything for “U”";
    Assert.assertEquals(userName, expected);
    driver.close();

}

@Test
    public void loginPhone() {
    loginobj = new Objects(driver);

loginobj.openURL();
loginobj.LoginBtn.click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
}
