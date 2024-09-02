package hpcases;

import objects.homepageObj;
import concepts.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
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

    @Test (groups = "Sanity")
    public void navigate2Search(){
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));
        String url = configReader.getURL();

        Reporter.log("Open the URL", true);

        driver.get(url);

        Reporter.log("Click on search button", true);

        homepage.searchButton.click();

        Reporter.log("Verify if search title is as expected", true);

        WebElement searchTitle = homepage.searchTitle;
        String searchTitleText = searchTitle.getText();
        System.out.println(searchTitleText);

        String expectedText = homepage.getExpectedSearchTitle();
        Assert.assertEquals(searchTitleText, expectedText);
        driver.quit();


    }




}
