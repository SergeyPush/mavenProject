package lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
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

    public LoginPage enterUsername(String email) {
        wait.until(visibilityOf(signInButton));
        signInButton.click();
        wait.until(visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public AccountPage clickSignInBtn() {
        logInButton.click();
        return new AccountPage(driver);
    }

    public AccountPage logIn(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }

    public String getPageName(){
        wait.until(visibilityOf(pageName));
        return pageName.getText();
    }
}
