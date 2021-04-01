package SoftwareTestingTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

public class AuthorizationTests extends BaseTest{
    @Test
    public void AuthorizationByAdminTests() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
