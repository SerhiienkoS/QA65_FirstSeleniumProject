package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "test258phone$@gmail.com");

        //enter password
        type(By.name("password"), "Nastya12#!");

        //click on Login button
        click(By.name("login"));

        //verify Sign Out button is display
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));


    }
}
