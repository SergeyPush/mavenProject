package lesson7;

import lesson7.pages.BaseTestClass;
import lesson7.pages.MainPage;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static lesson7.pages.CustomCondition.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomWaitsTest extends BaseTestClass {

    private MainPage mainPage;

    @Before
    public void setUp() {
        driver.get(BASE_URL);
    }

    @Test
    public void test001_verifyUrlAndTitle() {

        assertThat(pageIsLoaded("http://automationpractice.com/index.php", "My Store"));
    }


    @Test
    public void test002_verifyList() {
        mainPage = new MainPage(driver);
        mainPage.searchText("Printed Summer dress");

        // List to verify:
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='center_column']//h5/a"));

        new WebDriverWait(driver, 5).until(listNthElementHasText(list, 1, "Printed Summer Dress"));
    }

    @Test
    public void test003_verifyElementIsNotDisplayed() {

        mainPage = new MainPage(driver);

        //Element that must disappear:
        WebElement element = $("//*[@id='home-page-tabs']/li[1]/a");

        mainPage.signIn();
        new WebDriverWait(driver, 5).until(stalenessOfElement(element));


    }

}
