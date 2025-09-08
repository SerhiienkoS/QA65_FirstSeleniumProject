package com.ait.qa65;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findElementByTagName(){
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find list of elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("w"));
        System.out.println(elements.size());


    }
@Test
    public void sampleElementBySimpleLocators(){
    //find element by id
    driver.findElement(By.id("root"));
    //by className
    driver.findElement(By.className("header"));
    //by linkText
    driver.findElement(By.linkText("Let car work"));
    //by partial link text
    driver.findElement(By.partialLinkText("Let"));

}
}
