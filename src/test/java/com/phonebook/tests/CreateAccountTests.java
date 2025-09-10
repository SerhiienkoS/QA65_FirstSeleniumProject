package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "test258phone$"+i+"@gmail.com");

        //enter password
        type(By.name("password"), "Nastya12#!");

        //click on Registration button
        click(By.name("registration"));

        //verify Sign Out button is display
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));//css div:nth-child(1) button
    }


    @Test()
    public void existetUserRegistrationNegative() {
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "test258phone$@gmail.com");

        //enter password
        type(By.name("password"), "Nastya12#!");

        //click on Registration button
        click(By.name("registration"));

        //verify Sign Out button is display
        Assert.assertTrue(isAlertDisplayed());
    }

}
