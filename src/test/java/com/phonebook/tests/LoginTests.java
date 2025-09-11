package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User()
                .setEmail("test258phone$@gmail.com")
                .setPassword("Nastya12#!"));
        clickOnLoginButton();

        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Nastya12#!"));
        clickOnLoginButton();

        Assert.assertTrue(isAlertDisplayed());
    }
}
