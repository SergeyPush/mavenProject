package lesson5;

import lesson5.supplementary.BaseClass;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest extends BaseClass {


    @Test
    public void searchText() throws Exception {

        //Enter search word
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("Printed Summer Dress");
        searchField.submit();

        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));

        //Assert that number of elements is 3
        Assert.assertEquals("Number of elements is not equal to 3", 3, elementList.size());

        // Assert that first element contains "Printed Summer Dress"
        Assert.assertEquals("Printed Summer Dress", driver.findElement(By.xpath("//*[@id='center_column']//h5/a[1]")).getText());

    }
}
