package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver   driver = new ChromeDriver();
        driver.get("https://olx.com.pk/");
        driver.findElement(By.xpath("//span[@class='a1c1940e b7af14b4']")).click();
        driver.quit();



        }



    }
