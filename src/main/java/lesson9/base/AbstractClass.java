package lesson9.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class AbstractClass {

    abstract WebDriver getDriver();

    protected WebElement $(By locator){
        return getDriver().findElement(locator);
    }

    protected WebElement $(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }

}
