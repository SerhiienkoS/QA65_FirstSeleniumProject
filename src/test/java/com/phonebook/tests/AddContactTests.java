package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("test258phone$@gmail.com").setPassword("Nastya12#!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Viktor")
                .setLastName("Buch")
                .setPhone("0123456789")
                .setEmail("Viktor@mail.com")
                .setAddress("Ulmenstr.,35")
                .setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isContaktAdded("Viktor"));
    }

    @AfterMethod
    public void postCondition(){
        deleteContact();
    }

}
