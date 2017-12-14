package lesson9.pages;

import lesson9.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor)driver;

    @FindBy(css = "div.facebook-fanbox iframe")
    WebElement facebookBlock;





    public void scrollToFacebook() {

        js.executeScript("document.getElementById('facebook_block').scrollIntoView()");
            }

   /* public String getLinkText() {

        WebElement frame = driver.findElement(By.cssSelector("div.facebook-fanbox iframe"));

        driver.switchTo().frame(frame);

        return driver.findElement(By.cssSelector("div.lfloat a")).getText();

    }*/
}
