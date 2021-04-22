package SoftwareTestingTest;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Before

    public void loginByAdmin() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleIs("My Store"));
    }

    @Step
    public void openMyStore() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleIs("Online Store | My Store"));
    }

    @Step
    public void openCountriesPage() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wait.until(ExpectedConditions.titleIs("Countries | My Store"));
    }

    @Step
    public void openGeoZonesPage() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        wait.until(ExpectedConditions.titleIs("Geo Zones | My Store"));
    }

    @After
    public void stopDriver(){
        driver.quit();
        driver = null;
    }
}
