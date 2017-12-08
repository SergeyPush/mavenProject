package lesson7.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.search_query")
    WebElement searchField;

    @FindBy(css = "div.header_user_info")
    public WebElement signInButton;

    public void searchText(String text) {

        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }

    public void signIn() {

        signInButton.click();
    }
}
