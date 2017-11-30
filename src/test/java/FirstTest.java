import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest {


    protected static WebDriver webDriver;
    protected static final String BASE_URL = "https://github.com/";

    @BeforeClass
    public static void setUp() throws Exception {

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        webDriver.get(BASE_URL);

    }


    @AfterClass
    public static void tearDown() throws Exception {
        webDriver.quit();
        webDriver = null;

    }

    @Ignore
    @Test
    public void gitHubMustbeOpened() throws Exception {

        Assert.assertTrue("Error, it's not GitHub", webDriver.getTitle().contains("GitHub"));

    }

    @Ignore
    @Test
    public void searchRepository() throws Exception {
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys("Maven");
        searchField.submit();

    }
}
