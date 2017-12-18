package lesson10;

import lesson10.base.BaseTest;
import lesson10.pages.MainPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    private String product = "Blouse";


    @Test
    public void test001_verifyMainPageIsOpened() {

        Assert.assertThat(mainPage.getPageTitle(), is ("My Storeeeee"));
    }

    @Test
    public void test002_addProductToCart() {
        mainPage.addToCart(product);
    }

    @Test
    public void test003_verifyProductIsInCart() {
        Assert.assertThat(mainPage.getProductFromCart(), is(product));
    }
}
