package SoftwareTestingTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserRegistrationTest extends BaseTest{

    private final String TAX_ID = "1234567890";
    private final String COMPANY = "Test Company";
    private final String FIRST_NAME = "Julius";
    private final String LAST_NAME = "Meinl";
    private final String ADDRESS = "200 W 33rd St, Austin, TX 78705, США";
    private final String POSTCODE = getRandomNumber();
    private final String CITY = "Austin";
    private final String COUNTRY = "United States";
    private final String STATE = "Texas";
    private final String EMAIL = getRandomString(8) + "@test.ru";
    private final String PHONE = "+1111111111";
    private final String PASSWORD = "1q2w3e4r";

    public static String getRandomNumber() { return RandomStringUtils.randomNumeric(5); }

    public static String getRandomString(int length) { return RandomStringUtils.randomAlphabetic(length); }

    @Test
    public void registrationUser() throws InterruptedException {
        openMyStore();
        driver.findElement(By.cssSelector(".content a[href*='create_account']")).click();
        wait.until(ExpectedConditions.titleIs("Create Account | My Store"));
        Thread.sleep(500);

        //выбор страны
        driver.findElement(By.cssSelector("span[class*='select2']")).click();
        driver.findElement(By.cssSelector("input[class*='search__field']")).sendKeys(COUNTRY + Keys.ENTER);
        Thread.sleep(500);

        //выбор штата
        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        driver.findElement(By.cssSelector("option[value='TX']")).click();
        Thread.sleep(500);

        //запоолнение формы
        Actions action = new Actions(driver);
        action.click()
                .sendKeys(driver.findElement(By.name("tax_id")), TAX_ID).sendKeys(Keys.TAB)
                .sendKeys(COMPANY).sendKeys(Keys.TAB)
                .sendKeys(FIRST_NAME).sendKeys(Keys.TAB)
                .sendKeys(LAST_NAME).sendKeys(Keys.TAB)
                .sendKeys(ADDRESS).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(POSTCODE).sendKeys(Keys.TAB)
                .sendKeys(CITY).sendKeys(Keys.TAB)
                .sendKeys(COUNTRY).sendKeys(Keys.TAB)
                .sendKeys(STATE).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='email']")), EMAIL).sendKeys(Keys.TAB)
                .sendKeys(PHONE).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='password']")), PASSWORD).sendKeys(Keys.TAB)
                .sendKeys(driver.findElement(By.cssSelector("input[name='confirmed_password']")), PASSWORD)
                .perform();

        driver.findElement(By.cssSelector("button[name='create_account']")).click();
        wait.until(ExpectedConditions.titleIs("Online Store | My Store"));

        //разлогин
        WebElement logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        logout.click();
        Thread.sleep(500);

        //логин
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(EMAIL);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(500);

        //и еще раз разлогин
        logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        logout.click();
    }
}
