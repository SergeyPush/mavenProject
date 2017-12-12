package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ResultPage extends BasePage {


    private Actions hover = new Actions(driver);

    ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']//span[text()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='layer_cart']//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public void addToCart(String itemToBuy) {
        LOGGER.info("Add product to cart");

        hover.moveToElement($("//*[@id='center_column']//a[contains(text(), '" + itemToBuy + "')]")).perform();
        wait.until(visibilityOf(addToCartButton));
        addToCartButton.click();
    }


    public ShoppingCartSummaryPage proceedToCheckout() {
        LOGGER.info("Click Proceed to Checkout");

        wait.until(visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        return new ShoppingCartSummaryPage(driver);
    }
}
