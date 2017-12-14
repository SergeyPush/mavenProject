package lesson9;

import lesson9.base.BaseTest;
import lesson9.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class FacebookTest extends BaseTest{

    MainPage mainPage;


    private String stringToVerify = "PrestaShop";

    @Test
    public void checkFacebookLink() {


        mainPage = new MainPage(driver);

        //Scroll to Facebook frame
        mainPage.scrollToFacebook();


        //Assert that link text is PrestaShop
        Assert.assertThat(mainPage.getLinkText() , is("PrestaShop"));


    }
}
