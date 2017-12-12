package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage{
    AccountPage(WebDriver driver) {
        super(driver);
    }

    //Open History and Orders
    //$("//a[@title='Orders']").click();

    @FindBy(xpath = "//a[@title='Orders']")
    WebElement orderHistoryAndDetails;


    public OrderHistoryAndDetailsPage openHistoryAndOrders() {
        LOGGER.info("Click Proceed to Checkout");

        wait.until(ExpectedConditions.visibilityOf(orderHistoryAndDetails));
        orderHistoryAndDetails.click();
        return new OrderHistoryAndDetailsPage(driver);
    }


}
