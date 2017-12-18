package lesson10.base;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest extends AbstractClass {

    protected static WebDriver driver;
    protected static String BASE_URL = "http://automationpractice.com";

    protected static String email = "test_account@gmail.com";
    protected static String password = "test_account";


    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }
    };

    private void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("report.path") + "/screenshots/" + screenshot.getName();
        System.out.println("Screenshot has been taken");
        try {
            FileUtils.copyFile(screenshot, new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}

