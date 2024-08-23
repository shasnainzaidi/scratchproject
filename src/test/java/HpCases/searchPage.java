package HpCases;

import HomeObj.homepageObj;
import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchPage {
    private WebDriver driver;
    private concepts.configReader configReader;
    private homepageObj homepage;

    @BeforeMethod
    public void initialization(){
        WebDriverManager.chromedriver().setup();
        configReader = new configReader();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        homepage = new homepageObj(driver) ;

    }

    @Test
    public void navigate2Search(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));
        String url = configReader.getURL();
        driver.get(url);
        homepage.searchButton.click();

        WebElement searchTitle = homepage.searchTitle;
        String searchTitleText = searchTitle.getText();
        System.out.println(searchTitleText);

        String expectedText = "Pakistan Free classifieds";
        Assert.assertEquals(searchTitleText, expectedText);
        driver.quit();


    }




}
