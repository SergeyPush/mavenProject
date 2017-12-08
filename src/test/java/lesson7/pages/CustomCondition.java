package lesson7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.util.List;

public class CustomCondition {

    // pageIsLoaded, которое, ждет, чтоб титул страницы и ее url содержали указанные тексты;

    public static ExpectedCondition<Boolean> pageIsLoaded(String url, String title) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {

                String currentUrl = webDriver.getCurrentUrl();
                String pageTitle = webDriver.getTitle();

                return currentUrl.equals(url) & pageTitle.equals(title);

            }
        };
    }

    public static ExpectedCondition<List<WebElement>> listNthElementHasText(List<WebElement> list, int number, String text) {
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver webDriver) {

                try {
                    return list.get(number).getText().equalsIgnoreCase(text) ? list : null;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index out of bound");
                }

                return null;
            }
        };
    }

    public static ExpectedCondition<Boolean> stalenessOfElement(WebElement webElement) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {

                try {
                    webElement.isDisplayed();
                    return false;
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }
        };
    }

}
