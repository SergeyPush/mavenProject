package lesson7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractClass {


    public abstract WebDriver getWebDriver ();


    protected WebElement $(By locator){
        return getWebDriver().findElement(locator);
    }

    public WebElement $ (String xpath){
        return getWebDriver().findElement(By.xpath(xpath));
    }

    protected void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(getWebDriver(),5)).until(condition);
    }

//    protected void assertThat(ExpectedCondition<List<WebElement>> condition) {
//        (new WebDriverWait(getWebDriver(),5)).until(condition);
//    }
}
