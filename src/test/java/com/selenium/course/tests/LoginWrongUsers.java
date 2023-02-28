package com.selenium.course.tests;
import base.TestUtil;
import com.opencsv.CSVReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.time.Duration;

public class LoginWrongUsers extends TestUtil {
    @Test(dataProvider = "wrongUsers")
    public void unsuccessfulLogin (String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);

        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }
    @DataProvider(name = "wrongUsers")
    public Object [][] getUsers(){
        return new Object[][]{
                {"wrong", "secret_sauce"},
                {"standard_user", "wrong"},
                {"wrong", "wrong"}
        };
    }
}
