package config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jsUtils {
    WebDriver driver;

    public jsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollVertically(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Adjust if lazy loading causes the element to move
        try {
            Thread.sleep(500); // short wait for any lazy load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        js.executeScript("window.scrollBy(0, -100);"); // scroll back slightly to ensure visibility
    }
}

