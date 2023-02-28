package com.selenium.course.tests;
import base.TestUtil;
import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AddProduct extends TestUtil {

    @Test(dataProvider = "products")
    public void addItemToTheCart(String itemName1, String itemName2){
        LoginPage lgnPage = new LoginPage(driver);
        ProductPage prPage = lgnPage.login("problem_user","secret_sauce");

        prPage.addItemToTheCart(itemName1,itemName2);
        Assert.assertEquals(prPage.getItemsInTheCart(),2);
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
// 1. Login (choose username and password)
// 2. Add items by data provider(read from csv file)