package lesson9;

import lesson9.base.BaseTest;
import lesson9.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

public class FacebookTest extends BaseTest{

    MainPage mainPage;

    private String stringToVerify = "PrestaShop";

    @Test
    public void checkFacebookLink() {


        mainPage = new MainPage(driver);

        //Scroll to Facebook frame
        mainPage.scrollToFacebook();

        // Switch to frame
        WebElement frame = driver.findElement(By.cssSelector("div.facebook-fanbox iframe"));
        driver.switchTo().frame(frame);

        //Get link text
        String link = driver.findElement(By.cssSelector("div.lfloat a")).getText();

        //Assert that link text is PrestaShop
        Assert.assertThat(link, is("PrestaShop"));






    }
}
