package lesson8.pages;

import lesson8.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LogInPage extends BasePage {
    LogInPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".login")
    private WebElement signInButton;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(name = "SubmitLogin")
    private WebElement logInButton;

    @FindBy(css = "div.center_column h1")
    private WebElement pageName;

    public LogInPage enterUsername(String email) {
        LOGGER.info("Enter username");

        wait.until(visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public LogInPage enterPassword(String password) {
        LOGGER.info("Enter password");

        passwordField.sendKeys(password);
        return this;
    }

    public AddressPage clickSignInBtn() {
        LOGGER.info("Click Sign It button");

        logInButton.click();
        return new AddressPage(driver);
    }




}
