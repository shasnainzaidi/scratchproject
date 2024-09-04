package homepage;

import hpcases.baseTest;
import objects.homepageObj;
import concepts.configReader;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
//@Listeners(testNGListeners.class)
@Listeners({AllureTestNg.class})
public class homepage extends baseTest {

    private homepageObj homepg;
    private concepts.configReader configReader;



    @BeforeMethod(alwaysRun = true)
    public void initialization(){
        configReader = new configReader();
        homepg = new homepageObj(driver);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test (groups = "Sanity", priority=1)//(retryAnalyzer = retryAnalyzer.class)
    public void homepageAdLocation(){

    int timeout = Integer.parseInt(configReader.getProperty("timeout"));

    Reporter.log("Open the URL", true);
    homepg.openURL();
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

    Reporter.log("Click on Location Bar", true);
    homepg.l1Location.click();

    Reporter.log("Select L2 Location", true);

    homepg.l2Location.click();

    Reporter.log("Select L1 Location", true);
    homepg.l1Location.click();

    Reporter.log("Select L3 Location", true);
    homepg.l3Location.click();

        homepg.l1Location.click();

    Reporter.log("Select L3 Location", true);
    homepg.l4Location.click();

    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

    Reporter.log("Verify if the location is as expected on searchpage", true);

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        String expectedLocation = homepg.l4Location.getText();
        System.out.println(expectedLocation);

    Reporter.log("Scroll the page", true);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 1500);");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homepg.firstAd));

    Reporter.log("Click on 1st Ad", true);
    homepg.clickRandomElement();
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Reporter.log("get ad location", true);

    String actualLocation = homepg.adLocation.getText();
    System.out.println(actualLocation + " is actual Location of Ad opened");

  Assert.assertEquals (expectedLocation, actualLocation);

}

        @Test (priority=2)
    public void popularCategories(){
            int timeout = Integer.parseInt(configReader.getProperty("timeout"));

            Reporter.log("Open the main URL", true);
            homepg.openURL();
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


            String[] linkXPaths = homepg.getLinkXPaths();

            Reporter.log("Expected titles after redirection for each link", true);
            String[] expectedTitles = homepg.getExpectedTitles();
            for (int i = 0; i < linkXPaths.length; i++) {
                Reporter.log("Scroll down to the footer", true);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 5000);");

                Reporter.log("// Click on the link", true);
                driver.findElement(By.xpath(linkXPaths[i])).click();

                try {
                    Thread.sleep(2000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                String actualTitle = driver.getTitle();
                System.out.println("Actual Page Title for Link " + (i+1) + ": " + actualTitle);

                Assert.assertEquals(actualTitle, expectedTitles[i], "Redirection failed for Link " + (i+1) + " - Page title does not match");

                driver.navigate().back();

                driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            }


            }
    @Test (priority=3, enabled=false)
    public void trendingSearches() {
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

   homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);


        String[] linkXPaths = homepg.getLink2XPaths();

        String[] expectedTitles = homepg.getExpectedTitles2();
        for (int i = 0; i < linkXPaths.length; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 5000);");

            driver.findElement(By.xpath(linkXPaths[i])).click();
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            String actualTitle = driver.getTitle();
            System.out.println("Actual Page Title for Link " + (i+1) + ": " + actualTitle);

            Assert.assertEquals(actualTitle, expectedTitles[i], "Redirection failed for Link " + (i+1) + " - Page title does not match");

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }


        }
    @Test (priority=4)
    @Description("Verify the About us links from OLX Homepage footers")
    public void aboutUs(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        String[] linkXPaths = homepg.getLink3XPaths();

        String[] expectedURL = homepg.getExpectedURL3();

        for (int i = 0; i < linkXPaths.length; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 5000);");

            driver.findElement(By.xpath(linkXPaths[i])).click();
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            String actualURL = driver.getCurrentUrl();

            System.out.println("Actual URL for Link " + (i + 1) + ": " + actualURL);

            Assert.assertEquals(actualURL, expectedURL[i], "Redirection failed for Link " + (i + 1) + " - URL does not match");

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }

    }
    @Test
    public void olxFooter() {
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        String[] linkXPaths = homepg.getLink4XPaths();


        String[] expectedURL = homepg.getExpectedURL4();

        for (int i = 0; i < linkXPaths.length; i++) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 5000);");

            driver.findElement(By.xpath(linkXPaths[i])).click();

            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            String actualURL = driver.getCurrentUrl();

            System.out.println("Actual URL for Link " + (i + 1) + ": " + actualURL);

            Assert.assertEquals(actualURL, expectedURL[i], "Redirection failed for Link " + (i + 1) + " - URL does not match");

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }

    }
    @Test (groups = "Sanity")
    public void back2Top(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000);");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(homepg.back2Top));
        homepg.back2Top.click();


    }

}












