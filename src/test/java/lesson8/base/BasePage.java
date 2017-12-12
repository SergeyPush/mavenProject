package lesson8.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends AbstractClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final Logger LOGGER = LogManager.getLogger(this);

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @Override
    WebDriver getDriver() {
        return driver;
    }
}
