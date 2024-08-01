package HpCases;

import HomeObj.Objects;
import HomeObj.homepageObj;
import concepts.configReader;
import concepts.retryAnalyzer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class homepage {

    private WebDriver driver;
    private homepageObj homepg;
    private concepts.configReader configReader;

    @BeforeTest
    public void initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        configReader = new configReader();

    }
@Test //(retryAnalyzer = retryAnalyzer.class)
    public void homepageAdLocation(){

        homepg = new homepageObj(driver);
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
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    System.out.println("scroller moved");

    homepg.firstAd.click();
    String adLocation = homepg.adLocation.getText();

  Assert.assertEquals(l3Name, adLocation);








}


}