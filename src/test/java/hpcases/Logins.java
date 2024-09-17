package hpcases;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import objects.Objects;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
//@Listeners(testNGListeners.class)
@Listeners({AllureTestNg.class})
public class Logins extends baseTest{

    private Objects loginobj;
    private concepts.configReader configReader;


    @BeforeMethod(alwaysRun = true)
    public void Initialization() {
        loginobj = new Objects(driver);
        configReader = new concepts.configReader();


    }



@Test (groups ="Sanity", priority = 1)
  @Description("Verify login with Email")
    public void loginEmail(){

    int timeout = Integer.parseInt(configReader.getProperty("timeout"));


    loginobj.openURL();
loginobj.LoginBtn.click();
driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );
loginobj.LoginEmail.click();

loginobj.enteremail();
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
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test (groups ="Sanity", priority = 2)
@Description("Verify login with Phone Number")
    public void loginPhone(){
    int timeout = Integer.parseInt(configReader.getProperty("timeout"));

    loginobj = new Objects(driver);
    Allure.step("Opening the Website", () -> {
        loginobj.openURL();
    });


    loginobj.LoginBtn.click();


    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS );

    loginobj.LoginPhone.click();
    Allure.step("Enter Password", () -> {
        loginobj.enterPhone();
    });

        loginobj.enterPassword();
        loginobj.Login.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

    WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(loginobj.userDropdown));
    linkElement.click();
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
