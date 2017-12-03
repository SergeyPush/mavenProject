package lesson5;

import lesson5.utils.AbstractClass;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static lesson5.utils.MenuItem.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends AbstractClass {

    @After
    public void setUpMethod() throws Exception {
        // Return to My Account page
        driver.findElement(By.xpath("//div[@class='breadcrumb clearfix']//*[contains(text(), 'My account')]")).click();
    }

    @Test
    public void test001_CheckLoginSuccessful() throws Exception {

        // Login application with registered credentials
        login.logInApplication(email, password);

        // Check My account page is opened
        Assert.assertEquals("Login failed", "MY ACCOUNT", driver.findElement(By.cssSelector("h1.page-heading")).getText());

        // Check First and Last name
        Assert.assertEquals("Username is incorrect", "Sergey Test", driver.findElement(By.cssSelector("a.account")).getText());
    }

    @Test
    public void test002_openOrderHistory() throws Exception {

        //Open Order History and Details
        driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]")).click();

        // Assert that Order History and details is opened
        Assert.assertEquals("Order history is not opened", ORDER_HISTORY.getMenuItem(), driver.findElement(By.cssSelector("h1.page-heading")).getText());
    }

    @Test
    public void test003_openMyCreditSlips() throws Exception {

        //Open My Credit Slips
        driver.findElement(By.xpath("//span[contains(text(),'My credit slips')]")).click();

        // Assert that My credit slips is opened
        Assert.assertEquals("My credit slips is not opened", MY_CREDIT_SLIPS.getMenuItem(), driver.findElement(By.cssSelector("h1.page-heading")).getText());
    }

    @Test
    public void test004_openMyAddresses() throws Exception {

        //Open My addresses
        driver.findElement(By.xpath("//span[contains(text(),'My addresses')]")).click();

        // Assert that My addresses is opened
        Assert.assertEquals("My addresses is not opened", MY_ADRESSES.getMenuItem(), driver.findElement(By.cssSelector("h1.page-heading")).getText());
    }

    @Test
    public void test005_openMyPersonalInformation() throws Exception {

        //Open My personal information

        driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).click();

        // Assert that My personal information is opened
        Assert.assertEquals("My personal information is not opened", MY_PERSONAL_INFORMATION.getMenuItem(), driver.findElement(By.cssSelector("h1.page-subheading")).getText());
    }

    @Test
    public void test006_openMyWishlist() throws Exception {

        //Open My wishlists
        driver.findElement(By.xpath("//span[contains(text(),'My wishlists')]")).click();

        // Assert that My personal information is opened
        Assert.assertEquals("My wishlists is not opened", MY_WHISHLIST.getMenuItem(), driver.findElement(By.cssSelector("h1.page-heading")).getText());
    }


}
