package lesson8.pages;

import lesson6.pages.AccountPage;
import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressPage extends BasePage {
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']//button/span")
    WebElement proceedToCheckout;

    public ShippingPage proceedToCheckout() {
        LOGGER.info("Click Proceed to Checkout");

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
        proceedToCheckout.click();
        return  new ShippingPage(driver);
    }
}
