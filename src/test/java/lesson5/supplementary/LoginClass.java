package lesson5.supplementary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass {

    private WebDriver driver;

    public LoginClass(WebDriver driver) {
        this.driver = driver;
    }

    public void logInApplication(String email, String password) {

        //Click Sign In button
        driver.findElement(By.cssSelector("a.login")).click();

        //Enter email and password
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys(password);

        // Click submit button
        driver.findElement(By.name("SubmitLogin")).click();
    }

}
