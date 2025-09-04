package com.ait.qa65;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
WebDriver driver;
    //before method (pre-condition) -setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
//        driver.get("https://www.google.com"); // without history ( Incognito)
          //maximaze browser to window
          driver.manage().window().maximize();
          driver.navigate().to("https://www.google.com"); // with history
        // wait for all elements  on the site ( не явное ожидание)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.navigate().to("https://www.amazon.com");
          driver.navigate().back();
          driver.navigate().forward();
          driver.navigate().refresh();
//        driver.navigate().to("https://www.google.com"); // with history
    }


    //test-
    @Test
    public void openGoogleTest(){
        System.out.println("Google!!!!");
    }

    //after method - tearDown
    @AfterMethod (enabled = true)
    public void tearDown(){
//        driver.quit(); // all tabs and browser (он закрывает все вкладки и браузер)
        driver.close(); // only ona tab (if only one -> close browser) текущая
    }
}
