package com.selenium.course.tests;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class UserInfoInput extends TestUtil {
    @Test
    public void userInfoInput() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("standard_user","secret_sauce");
        prPage.addItemToTheCart("backpack","bike-light");

        YourCartPage cartPage = prPage.cartBadgeClick();
        CheckoutInfoPage infoPage = cartPage.clickCheckout();
        infoPage.infoInput();
    }
}
// Test user information input(first name, last name, postal code).
// 1. Login (choose username and password).
// 2. Add item to cart (choose 3 items).
// 3. Go to "Your cart".
// 4. Click  checkout button.
// 5. Input user information (send keys in CheckoutInfoPage)
// 6. Passed test will go to the next page.