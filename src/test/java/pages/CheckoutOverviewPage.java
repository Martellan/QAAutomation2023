package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement checkoutComplete;

    @FindBy(className = "complete-header")
    public WebElement completeText;

    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;

    public void checkout(){
        finishBtn.click();
    }
}
// Constructor, elements and method (checkout products)