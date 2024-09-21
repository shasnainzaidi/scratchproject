package hpcases;

import concepts.configReader;
import objects.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class unifiedLogin extends baseTest {

    private concepts.configReader configReader;
    private Objects loginobj;

    @BeforeMethod
    public void initialization(){
        loginobj = new Objects(driver);
        configReader = new configReader();
    }

    @Test
    public void loginValidEmail(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));


        loginobj.openURL();
        loginobj.LoginBtn.click();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );
        loginobj.LoginEmail.click();

        loginobj.enterEmail("hasnain.xaidi1@gmail.com");
        loginobj.enterPassword();
        loginobj.Login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(loginobj.userDropdown));
        linkElement.click();
        WebElement userNameElement = loginobj.userNameElement;
        String userName = userNameElement.getText();
        System.out.println(userName);
        String expected= "Everything for “U”";
        Assert.assertEquals(userName, expected);


    }
    @Test
    public void InValidEmail() {
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        try {
            loginobj.openURL();
            loginobj.LoginBtn.click();
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            loginobj.LoginEmail.click();

            loginobj.enterEmail("hasnin.xaidi1@gmail.com");
            loginobj.enterPassword();
            loginobj.Login.click();
            String errorMessage = loginobj.emailErrorMessage.getText();
            System.out.println(errorMessage);
            String expectedMessage = "The e-mail address must be in the format of name@domain.com";
            Assert.assertEquals(errorMessage, expectedMessage);
        } catch (Exception ecp) {

            System.out.println("We are having some error in code");


        } finally {
            System.out.println("cant run the test");


        }


    }
}
