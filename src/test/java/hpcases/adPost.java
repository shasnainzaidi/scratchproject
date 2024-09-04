package hpcases;

import concepts.configReader;
import io.qameta.allure.testng.AllureTestNg;
import objects.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.Driver;

@Listeners({AllureTestNg.class})
public class adPost extends Logins{

    private static final Logger log = LoggerFactory.getLogger(adPost.class);
    private Objects loginObj;
private concepts.configReader configReader;

@BeforeMethod(alwaysRun = true)
    public void setupPage(){
    loginObj = new Objects(driver);
    configReader = new configReader();
}
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test (groups ="Sanity")
    public void freeAdPost(){
    loginEmail();
    int timeout = Integer.parseInt(configReader.getProperty("timeout"));

    System.out.println("Login done");

    loginObj.sellBtn.click();
    try {
        Thread.sleep(2000);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }

    loginObj.selectCategory.click();
    loginObj.selectSubCategory.click();
    loginObj.imageAddBtn.click();
    try {
        Runtime.getRuntime().exec("D:/AutoITimage.exe");
    } catch (IOException e) {
        e.printStackTrace();
    }

    loginObj.makeOption.click();
    loginObj.makeSelection.click();

    loginObj.conditionOption.click();
    loginObj.conditionSelection.click();

    loginObj.addTitle();
    loginObj.adddescription();
    loginObj.adLocation.click();
    loginObj.locationSelection.click();
    loginObj.addprice();
    loginObj.imageRemoveBtn.click();

}

}

