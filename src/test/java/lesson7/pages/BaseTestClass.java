package lesson7.pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestClass extends AbstractClass{

    protected static WebDriver driver;
    protected static String BASE_URL = "http://automationpractice.com";

    protected static String email = "test_account@gmail.com";
    protected static String password = "test_account";

    @BeforeClass
    public static void setUpClass() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        driver.quit();
        driver = null;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
