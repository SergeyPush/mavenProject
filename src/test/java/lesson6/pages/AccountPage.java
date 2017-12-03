package lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AccountPage {

    private WebDriverWait wait;
    private WebDriver driver;

    AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(css = ".logout")
    private WebElement logOutButton;

    @FindBy(css = "a.account span")
    private WebElement userName;

    @FindBy(css = "div.center_column h1")
    private WebElement pageName;

    public AccountPage logOut() {

        logOutButton.click();
        return new AccountPage(driver);
    }

    public String getUserName() {

        wait.until(visibilityOf(userName));
        return userName.getText();
    }

    public String getPageName() {

        wait.until(visibilityOf(pageName));
        return pageName.getText();
    }
}
