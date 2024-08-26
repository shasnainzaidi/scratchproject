package homepage;

import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import objects.homepageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class allcategories {
    private WebDriver driver;
    private homepageObj homepg;
    private concepts.configReader configReader;
    @BeforeMethod
    public void initialization(){
        WebDriverManager.chromedriver().setup();
        configReader = new configReader();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        homepg = new homepageObj(driver);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority=0)
    @Description("Verify the category icons on homepage")
    public void allCategories(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        homepg.openURL();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        String[] linkXPaths = homepg.getLink5XPaths();

        String[] expectedURL = homepg.getExpectedURL5();
        //String[] expectedTitle = homepg.getExpectedTitles5();

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
           // String actualTitle = driver.findElement(By.cssSelector("._7c57f8f7")).getText();
            //homepg.searchTitle.getText();

            System.out.println("Actual URL for Link " + (i + 1) + ": " + actualURL);
           // System.out.println("Actual Title for Link " + (i + 1) + ": " + actualTitle);

            Assert.assertEquals(actualURL, expectedURL[i], "Redirection failed for Link " + (i + 1) + " - URL does not match");
           // Assert.assertEquals(actualTitle, expectedTitle[i], "Redirection failed for Link " + (i + 1) + " - Title does not match");

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        }

    }

}


