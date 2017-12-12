package lesson8.pages;

import lesson8.base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = "input.search_query")
    WebElement searchField;

    @FindBy(xpath = "//a[@class='account']/span")
    WebElement myAccountButton;


    public ResultPage searchProduct(String query) {
        LOGGER.info("Search product: "+ query);

        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }


    public AccountPage openMyAccount() {
        LOGGER.info("Open My account");
        myAccountButton.click();


        return new AccountPage(driver);
    }
}
