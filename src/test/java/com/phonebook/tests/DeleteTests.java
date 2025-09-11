package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User()
                .setEmail("test258phone$@gmail.com")
                .setPassword("Nastya12#!"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Viktor")
                .setLastName("Buch")
                .setPhone("0123456789")
                .setEmail("Viktor@mail.com")
                .setAddress("Ulmenstr.,35")
                .setDescription("QA"));
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore -1);
    }

}
