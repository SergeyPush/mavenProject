package lesson9.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}

