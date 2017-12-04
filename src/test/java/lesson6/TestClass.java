package lesson6;

import lesson6.pages.AccountPage;
import lesson6.pages.BaseClass;
import lesson6.pages.LoginPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass extends BaseClass {

    private LoginPage loginPage = new LoginPage(driver);
    private AccountPage accountPage;

    @Ignore
    @Test
    public void test001_LoginViaLogIn() throws Exception {

        accountPage = loginPage.logIn(email, password);

    }

    @Ignore
    @Test
    public void test002_LoginViaMethodChain() throws Exception {

        accountPage = loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();
    }


    @Test
    public void test003_LogOut() throws Exception {

        accountPage = loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();

        //Check that Account page is displayed
        Assert.assertThat("Username is incorrect", accountPage.getUserName(), is("Sergey Test"));
        Assert.assertThat("Page name is incorrect", accountPage.getPageName(), equalTo("MY ACCOUNT"));

        //Click Logout
        accountPage.logOut();

        //Check that user SignedOut
        Assert.assertThat("User is not SignedOut", loginPage.getPageName(), is("AUTHENTICATION"));

    }
}
