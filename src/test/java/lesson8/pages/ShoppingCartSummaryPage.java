package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends BasePage{

    ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@id='center_column']//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;


    public LogInPage proceedToCheckout() {
        LOGGER.info("Click Proceed to Checkout");

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        return new LogInPage(driver);
    }
}
