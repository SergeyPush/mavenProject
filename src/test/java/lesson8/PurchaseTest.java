package lesson8;

import lesson8.pages.*;
import lesson8.base.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseTest extends BaseTest {

    private MainPage mainPage = new MainPage(driver);
    private String itemToBuy = "Blouse";

    @Test
    public void test001_buySomeItem() {


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

        AccountPage accountPage = mainPage.openMyAccount();

        //Open History and Orders
        OrderHistoryAndDetailsPage orderHistory = accountPage.openHistoryAndOrders();

        //Open first item in page
        orderHistory.openFirstItem();

        //Get name of the item
        orderHistory.getFirstItem();

        Assert.assertThat(orderHistory.getFirstItem(), containsString(itemToBuy));


    }
}
