package hpcases;

import concepts.configReader;
import objects.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;

public class adPost extends Logins{

private Objects loginObj;
private concepts.configReader configReader;

@BeforeMethod
    public void setupPage(){
    loginObj = new Objects(driver);
    configReader = new configReader();

}
@Test
    public void adPost(){
    loginEmail();
    System.out.println("Login done");

loginObj.sellBtn.click();
    try {
        Thread.sleep(2000);
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }


    System.out.println("Clicked on sell button");

loginObj.selectCategory.click();
loginObj.selectSubCategory.click();
loginObj.imageAddBtn.click();
    try {
        Runtime.getRuntime().exec("D:/AutoITimage.exe");
    } catch (IOException e) {
        e.printStackTrace(); // Print the stack trace to understand the issue
    }

    System.out.println("image uploaded");

    driver.findElement(By.xpath("//input[@id='make']")).click();
//   WebElement dropdown=  driver.findElement(By.xpath("//input[@id='make']"));
  //  Select select = new Select(dropdown);
   // select.selectByVisibleText("Apple iPhone");
    driver.findElement(By.xpath("//div[normalize-space()='Acer']")).click();
    System.out.println("Brand Selected");

    WebElement condition=  driver.findElement(By.xpath("//input[@id='new_used']"));
    Select select2 = new Select(condition);
    select2.selectByVisibleText("Open Box");

    driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Mobile for sale in Lahore");
    // Provide the absolute path to the file on your system



}

}

