package lesson8.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest extends AbstractClass{

    protected static WebDriver driver;
    protected static String BASE_URL = "http://automationpractice.com";

    protected static String email = "test_account@gmail.com";
    protected static String password = "test_account";

    @BeforeClass
    public static void setUpClass() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASE_URL);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        driver.quit();
        driver = null;
    }

    @Override
    WebDriver getDriver() {
        return driver;
    }
}

