package visuals;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class detailPage {

        private final int viewPortWidth = 800;
        private final int viewPortHeight = 600;
        String myEyesServer = "https://eyes.applitools.com/"; //set to your server/cloud URL
        String appName = "OLX";
        String batchName = "OLX DPV";
        private EyesRunner runner = null;
        private com.applitools.eyes.config.Configuration suiteConfig;
        private Eyes eyes;
        private WebDriver webDriver;

        @Test
    public void newTest(){
            WebDriver driver = new ChromeDriver();
            Eyes eyes = new Eyes();

            eyes.setApiKey("SiTp2npDN61077v5GYyuXWip214gWwtSKBgwo2cP4g2D4110");

            try {
                eyes.open(driver, "Applitools Test", "My first Visual test!", new RectangleSize(800, 600));

                driver.get("https://www.olx.com.pk/item/realme-gt-mater-edition-5g-iid-1090853567");

                eyes.checkWindow("Before number viewed");

                driver.findElement(By.xpath("//span[.='Show phone number']")).click();
                eyes.checkWindow("After number viewed");

                eyes.close();
            } finally {
                driver.quit();
                eyes.abortIfNotClosed();
            }
        }


        }



