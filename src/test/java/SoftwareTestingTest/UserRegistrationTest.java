package SoftwareTestingTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserRegistrationTest extends BaseTest{

    public static String getRandomNumber() { return RandomStringUtils.randomNumeric(5); }

    public static String getRandomString(int length) { return RandomStringUtils.randomAlphabetic(length); }

        private final String taxId = "1234567890";
        private final String company = "Test Company";
        private final String firstName = "Julius";
        private final String lastName = "Meinl";
        private final String address = "200 W 33rd St, Austin, TX 78705, США";
        private final String postcode = getRandomNumber();
        private final String city = "Austin";
        private final String country = "United States";
        private final String state = "Texas";
        private final String email = getRandomString(8) + "@test.ru";
        private final String phone = "+1111111111";
        private final String password = "1q2w3e4r";

    @Test
    public void registrationUser() throws InterruptedException {
        openMyStore();
        driver.findElement(By.cssSelector(".content a[href*='create_account']")).click();
        wait.until(ExpectedConditions.titleIs("Create Account | My Store"));
        Thread.sleep(500);

        //выбор страны
        driver.findElement(By.cssSelector("span[class*='select2']")).click();
        driver.findElement(By.cssSelector("input[class*='search__field']")).sendKeys(country + Keys.ENTER);
        Thread.sleep(500);

        //выбор штата
        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        driver.findElement(By.cssSelector("option[value='TX']")).click();
        Thread.sleep(500);

        //запоолнение формы
        Actions action = new Actions(driver);
        action.click()
                .sendKeys(driver.findElement(By.name("tax_id")), taxId).sendKeys(Keys.TAB)
                .sendKeys(company).sendKeys(Keys.TAB)
                .sendKeys(firstName).sendKeys(Keys.TAB)
                .sendKeys(lastName).sendKeys(Keys.TAB)
                .sendKeys(address).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(postcode).sendKeys(Keys.TAB)
                .sendKeys(city).sendKeys(Keys.TAB)
                .sendKeys(country).sendKeys(Keys.TAB)
                .sendKeys(state).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='email']")), email).sendKeys(Keys.TAB)
                .sendKeys(phone).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='password']")), password).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='confirmed_password']")), password)
                .perform();

        driver.findElement(By.cssSelector("button[name='create_account']")).click();
        wait.until(ExpectedConditions.titleIs("Online Store | My Store"));

        //разлогин
        WebElement logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        logout.click();
        Thread.sleep(500);

        //логин
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(500);

        //и еще раз разлогин
        logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        logout.click();
    }
}
