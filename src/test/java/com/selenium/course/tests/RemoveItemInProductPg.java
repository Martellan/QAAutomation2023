package com.selenium.course.tests;

import base.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

import java.time.Duration;

public class RemoveItemInProductPg extends TestUtil {
    @Test
    public void removeItem() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("problem_user","secret_sauce");

        prPage.addItemToTheCart("backpack","bike-light");
        Assert.assertEquals(prPage.getItemsInTheCart(),2);

        prPage.removeItemFromCart("backpack");
        Assert.assertEquals(prPage.getItemsInTheCart(),1);
    }
}
// Test for removing items in PRODUCT PAGE.
// 1. Login.
// 2. Add items to cart
// 3. Choose witch item to be removed.
