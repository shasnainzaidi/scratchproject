package HpCases;

import HomeObj.Objects;
import HomeObj.homepageObj;
import concepts.configReader;
import concepts.retryAnalyzer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//@Listeners(testNGListeners.class)

public class homepage {

    private WebDriver driver;
    private homepageObj homepg;
    private concepts.configReader configReader;



    @BeforeMethod
    public void initialization(){
        WebDriverManager.chromedriver().setup();
        configReader = new configReader();
        driver = new ChromeDriver();
        homepg = new homepageObj(driver);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test //(retryAnalyzer = retryAnalyzer.class)
    public void homepageAdLocation(){

    int timeout = Integer.parseInt(configReader.getProperty("timeout"));

    homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        homepg.l1Location.click();
        homepg.l2Location.click();

    homepg.l1Location.click();
        homepg.l3Location.click();
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


    String l3Name = homepg.homeLocation.getText();
        System.out.println(l3Name);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 2000);");

    System.out.println("scroller moved");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homepg.firstAd));

   // homepg.firstAd.click();
    String adLocation = homepg.adLocation.getText();

  Assert.assertEquals(l3Name, adLocation);

}

        @Test
    public void allFooters(){
            int timeout = Integer.parseInt(configReader.getProperty("timeout"));

            // Open the main URL
            homepg.openURL();
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


            String[] linkXPaths = homepg.getLinkXPaths();

            // Expected titles after redirection for each link
            String[] expectedTitles = homepg.getExpectedTitles();
            for (int i = 0; i < linkXPaths.length; i++) {
                // Scroll down to the footer (optional based on your page structure)
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 5000);");

                // Click on the link
                driver.findElement(By.xpath(linkXPaths[i])).click();

                String actualTitle = driver.getTitle();
                System.out.println("Actual Page Title for Link " + (i+1) + ": " + actualTitle);

                // Assert redirection success based on the page title
                Assert.assertEquals(actualTitle, expectedTitles[i], "Redirection failed for Link " + (i+1) + " - Page title does not match");

                driver.navigate().back();

                // Implicit wait to ensure the main page is fully loaded before testing the next link
                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            }


            }
    @Test
    public void trendingSearches() {
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

   homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


        String[] linkXPaths = homepg.getLink2XPaths();

        // Expected titles after redirection for each link
        String[] expectedTitles = homepg.getExpectedTitles2();
        for (int i = 0; i < linkXPaths.length; i++) {
            // Scroll down to the footer (optional based on your page structure)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 5000);");

            // Click on the link
            driver.findElement(By.xpath(linkXPaths[i])).click();

            String actualTitle = driver.getTitle();
            System.out.println("Actual Page Title for Link " + (i+1) + ": " + actualTitle);

            // Assert redirection success based on the page title
            Assert.assertEquals(actualTitle, expectedTitles[i], "Redirection failed for Link " + (i+1) + " - Page title does not match");

            driver.navigate().back();

            // Implicit wait to ensure the main page is fully loaded before testing the next link
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }

        }}












