package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {
    //login
    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "test258phone$@gmail.com");
        type(By.name("password"), "Nastya12#!");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest_() {
        //click on ADD link
        click(By.cssSelector("[href='/add']"));

        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Viktor");
        //enter last name
        type(By.cssSelector("input:nth-child(2)"), "Buch");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "0123456789");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "Viktor@mail.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Ulmenstr.,35");
        //enter description
        type(By.cssSelector("input:nth-child(6)"), "QA");

        //click on Save button
        click(By.cssSelector(".add_main__1tbl_ button"));

        //verify contact is added
        Assert.assertTrue(isContaktAdded("Viktor"));
    }

    public boolean isContaktAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element:contacts){
            if (element.getText().contains(text));
            return true;
        }
        return false;
    }

    @AfterMethod
    public void postCondition(){
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
    }
}
