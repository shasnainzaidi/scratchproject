package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class baseTest {
    private WebDriver driver;
    private configReader configReader;

    @Test
    public void setUp(){
        configReader = new configReader();
        String browser = configReader.getProperty("browser");
        String url = configReader.getProperty("URL");
        int timeout = Integer.parseInt(configReader.getProperty("timeout"));

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
            else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

            }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }




    }
