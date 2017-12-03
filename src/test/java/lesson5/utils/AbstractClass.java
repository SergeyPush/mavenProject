package lesson5.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AbstractClass {
    protected static WebDriver driver;
    private static String BASE_URL = "http://automationpractice.com";

    protected static String email = "test_account@gmail.com";
    protected static String password = "test_account";

    protected static LoginClass login;


    @BeforeClass
    public static void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        login = new LoginClass(driver);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
