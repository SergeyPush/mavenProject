package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends BasePage {
    ShippingPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id='cgv']")
    WebElement agreeCheckbox;

    public PaymentPage proceedToCheckout(){
        LOGGER.info("Click Proceed to Checkout");

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        agreeCheckbox.click();
        proceedToCheckoutButton.click();
        return new PaymentPage(driver);
    }

}
