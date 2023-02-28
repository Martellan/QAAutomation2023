package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {
    //Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //Elements
    @FindBy(xpath = "//span[@class='title']")
    public WebElement productsPageHeading;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    //Constant
    private final static String PRODUCT_ID = "add-to-cart-sauce-labs-";

    //Method
    public void  addItemToTheCart(String itemName, String itemName2){

        WebElement itemToBeAdded1 = driver.findElement(By.id(PRODUCT_ID + itemName));
        WebElement itemToBeAdded2 = driver.findElement(By.id(PRODUCT_ID + itemName2));

        itemToBeAdded1.click();
        itemToBeAdded2.click();
    }
    public int getItemsInTheCart() {
        return Integer.parseInt(cartBadge.getText());
    }
    public final static String REMOVE_BTN = "remove-sauce-labs-";

    public void removeItemFromCart(String itemName) {
        WebElement removeItem = driver.findElement(By.id(REMOVE_BTN + itemName));

        WebDriverWait waitItem = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitItem.until(ExpectedConditions.elementToBeClickable(removeItem));

        removeItem.click();
    }
    public YourCartPage cartBadgeClick(){
        cartBadge.click();
        return new YourCartPage(driver);
    }
}


