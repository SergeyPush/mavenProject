package lesson10.pages;

import lesson9.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    private Actions hover = new Actions(driver);

    public String getPageTitle() {
        return driver.getTitle();
    }


    public void addToCart(String product) {


        hover.moveToElement($("//*[@id='homefeatured']/li//a[contains(text(), '"+product+"')]")).perform();
        $("//*[@id='homefeatured']/li//a[contains(text(), '"+product+"')]/../..//span[contains(text(), 'Add to cart')]").click();
        wait.until(ExpectedConditions.visibilityOf($(By.cssSelector("#layer_cart span.continue "))));
        $(By.cssSelector("#layer_cart span.continue ")).click();

    }

    public String getProductFromCart() {
        hover.moveToElement($(By.cssSelector("div.shopping_cart a"))).perform();
        return $(By.cssSelector("div.shopping_cart a.cart_block_product_name")).getText();

    }
}



