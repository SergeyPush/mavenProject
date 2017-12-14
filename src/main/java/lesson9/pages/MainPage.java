package lesson9.pages;

import lesson9.base.BasePage;
import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = "div.facebook-fanbox iframe")
    WebElement iframe;

    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void scrollToFacebook() {

        js.executeScript("document.getElementById('facebook_block').scrollIntoView()");
    }

    public String getLinkText() {

        // Switch to frame
//        WebElement frame = driver.findElement(By.cssSelector("div.facebook-fanbox iframe"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

        // Get Link text
        String lt = driver.findElement(By.cssSelector("div.lfloat a")).getText();

        driver.switchTo().defaultContent();

        return lt;
    }


}
