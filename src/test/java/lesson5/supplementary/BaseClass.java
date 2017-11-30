package lesson5.supplementary;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected static WebDriver driver;
    protected static String BASE_URL = "http://automationpractice.com";

    protected static String email = "test_account@gmail.com";
    protected static String password = "test_account";

    public static LoginClass login;


    @BeforeClass
    public static void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        login = new LoginClass(driver);
//        login.logInApplication(email, password);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
