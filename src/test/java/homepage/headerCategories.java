package homepage;

import hpcases.baseTest;
import objects.homepageObj;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class headerCategories extends baseTest {

    private homepageObj homepg;

    @BeforeMethod
    public void setupPage(){

        homepg = new homepageObj(driver);
    }
@Test
    public void allCatDrop(){

        homepg.openURL();
        homepg.allCatDrop.click();
        homepg.catDrop.click();
    try {
        Thread.sleep(1000);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }

        String expectedTitle = homepg.getExpectedTitleDrop();
        String actualTitle = homepg.searchTitle.getText();
    Assert.assertEquals(expectedTitle, actualTitle);

        driver.quit();

}

@Test
    public void multipleX(){
        homepg.openURL();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 1500);");
        homepg.clickRandomElement();


}

}
