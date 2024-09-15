package homepage;

import concepts.configReader;
import hpcases.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import objects.homepageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class allcategories extends baseTest {
    private homepageObj homepg;
    private concepts.configReader configReader;

    @BeforeMethod
    public void initialization(){

        configReader = new configReader();
        homepg = new homepageObj(driver);
    }

    @Test(priority=0)
    @Description("Verify the category icons on homepage")
    public void allCategories(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        String[] linkXPaths = homepg.getLink5XPaths();

        String[] expectedURL = homepg.getExpectedURL5();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        for (int i = 0; i < linkXPaths.length; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 5000);");

            WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXPaths[i])));
            linkElement.click();

            String actualURL = driver.getCurrentUrl();

            System.out.println("Actual URL for Link " + (i + 1) + ": " + actualURL);

            Assert.assertEquals(actualURL, expectedURL[i], "Redirection failed for Link " + (i + 1) + " - URL does not match");

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }

    }

}


