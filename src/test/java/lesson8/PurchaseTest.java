package lesson8;

import lesson8.pages.*;
import lesson8.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PurchaseTest extends BaseTest{

    private MainPage mainPage;

    private String itemToBuy = "Blouse";


    @Test
    public void test001_buySomeItem() throws InterruptedException {
        mainPage = new MainPage(driver);


        ResultPage resultPage = mainPage.searchProduct(itemToBuy);
        resultPage.addToCart(itemToBuy);
        ShoppingCartSummaryPage shoppingCartSummary = resultPage.proceedToCheckout();
        LogInPage logInPage = shoppingCartSummary.proceedToCheckout();
        AddressPage addressPage = logInPage.enterUsername(email).enterPassword(password).clickSignInBtn();
        ShippingPage shippingPage = addressPage.proceedToCheckout();
        PaymentPage paymentPage = shippingPage.proceedToCheckout();
        paymentPage.payByBankWire();

        assertThat($(By.cssSelector("h1.page-heading")).getText(), is("ORDER CONFIRMATION"));
        assertThat($(By.cssSelector("p strong.dark")).getText(), is("Your order on My Store is complete."));
    }

    @Test
    public void test002_verifyItemIsBought() {

        //Open My account
        $("//a[@class='account']/span").click();

        //Open History and Orders
        $("//a[@title='Orders']").click();

        //Open first item in page
        $("//*[@id='order-list']/tbody/tr[1]/td[1]").click();

        //Get name of the item
        WebElement itemName = $("//*[@id='order-detail-content']/table/tbody/tr/td[2]/label");

        Assert.assertThat(itemName.getText(), containsString(itemToBuy));


    }
}
