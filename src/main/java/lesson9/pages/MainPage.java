package lesson9.pages;

import lesson9.base.BasePage;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void scrollToFacebook() {

        js.executeScript("document.getElementById('facebook_block').scrollIntoView()");
    }

    public String getLinkText() {

        // Switch to frame
        WebElement frame = driver.findElement(By.cssSelector("div.facebook-fanbox iframe"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

        // Get Link text
        return driver.findElement(By.cssSelector("div.lfloat a")).getText();
    }


}
