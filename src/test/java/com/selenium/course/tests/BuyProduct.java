package com.selenium.course.tests;
import base.TestUtil;
import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BuyProduct extends TestUtil {
    @Test(dataProvider = "products")
    public void buyProduct(String itemName1, String itemName2) {
        LoginPage lgnPage = new LoginPage(driver);
        ProductPage prPage = lgnPage.login("standard_user", "secret_sauce");

        prPage.addItemToTheCart(itemName1, itemName2);
        YourCartPage cartPage = prPage.cartBadgeClick();

        CheckoutInfoPage infoPage = cartPage.clickCheckout();
        CheckoutOverviewPage overview = infoPage.infoInput();

        overview.checkout();

        Assert.assertEquals(overview.checkoutComplete.getText(), "Checkout: Complete!");
        Assert.assertEquals(overview.completeText.getText(), "Thank you for your order!");
        Assert.assertTrue(overview.backHomeBtn.isDisplayed());
        //Asserts

    }

    @DataProvider(name = "products")
    public static Object[][] readUsersFromCsv() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/products.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;
        } catch (IOException e) {
            System.out.println("Not possible to find fileName");
            return null;
        }
    }
}
// 1. Login.
// 2. Add products to the cart. (read from csv),.
// 3. Go to "Your cart" with our added products.
// 4. Click on cart badge link button to go "checkout:Info" and input user information.
// 5. Checkout/buy products (click finish button).
