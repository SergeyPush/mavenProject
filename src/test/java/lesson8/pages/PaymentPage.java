package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage{
    PaymentPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    WebElement payByBankWireButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement confirmMyOrderButton;

    public void payByBankWire() {
        wait.until(ExpectedConditions.visibilityOf(payByBankWireButton));
        payByBankWireButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmMyOrderButton));
        confirmMyOrderButton.click();

    }
}
