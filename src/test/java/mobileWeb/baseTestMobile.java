package mobileWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class baseTestMobile {
    protected WebDriver driver;
    protected concepts.configReader configReader;

    @BeforeMethod
    @Parameters("deviceName")

    public void setUp(@Optional("desktop") String deviceName) {
        WebDriverManager.chromedriver().setup();
        configReader = new concepts.configReader();
        ChromeOptions options = new ChromeOptions();

        if (deviceName.equalsIgnoreCase("mobile")) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X"); // You can use other device names, e.g., "Pixel 2", "Galaxy S5", etc.
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        }
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
