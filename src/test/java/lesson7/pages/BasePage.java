package lesson7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends AbstractClass{

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
