package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistoryAndDetailsPage extends BasePage {
    OrderHistoryAndDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]")
    WebElement firstItem;

    @FindBy(xpath = "//*[@id='order-detail-content']/table/tbody/tr/td[2]/label")
    WebElement firstItemName;


    public void openFirstItem() {
        LOGGER.info("Open last purchased item");

        wait.until(ExpectedConditions.visibilityOf(firstItem));
        firstItem.click();
    }

    public String getFirstItem() {
        LOGGER.info("Get name of last purchase");

        wait.until(ExpectedConditions.visibilityOf(firstItemName));
        return firstItemName.getText();
    }
}
