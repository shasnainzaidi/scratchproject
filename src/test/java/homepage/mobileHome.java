package homepage;

import concepts.configReader;
import objects.Objects;
import objects.homepageObj;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mobileHome extends baseTestM {

    private homepageObj homepg;
    private concepts.configReader configReader;

    @BeforeMethod
    public void setupPage() {
        homepg = new homepageObj(driver);
        configReader = new configReader();

    }

    @Test
    public void homepageMobile() {
homepg.openURL();
homepg.mobileConfirm.click();
homepg.otherLocation.click();
homepg.seePak.click();
    }
}