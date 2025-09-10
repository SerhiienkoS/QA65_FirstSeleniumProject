package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends TestBase{


    @BeforeMethod
    public void precondition(){
        //login
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "test258phone$@gmail.com");
        type(By.name("password"), "Nastya12#!");
        click(By.name("login"));

        //add contact
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Viktor");
        type(By.cssSelector("input:nth-child(2)"), "Buch");
        type(By.cssSelector("input:nth-child(3)"), "0123456789");
        type(By.cssSelector("input:nth-child(4)"), "Viktor@mail.com");
        type(By.cssSelector("input:nth-child(5)"), "Ulmenstr.,35");
        type(By.cssSelector("input:nth-child(6)"), "QA");
        click(By.cssSelector(".add_main__1tbl_ button"));
    }

    @Test
    public void deleteContactTest(){
        //click on the card
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        //click on Remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();
    }

    //verify contact is deleted
}
