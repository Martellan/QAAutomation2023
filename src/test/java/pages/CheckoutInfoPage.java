package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;


    public CheckoutOverviewPage infoInput() {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Martin");

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Yordanov");

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys("5000");

        continueBtn.click();

        return new CheckoutOverviewPage(driver);
    }
}
// Constructor, Elements, Method ( user info input and go to next page)



