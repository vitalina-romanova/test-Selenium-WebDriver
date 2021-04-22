package SoftwareTestingTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class AddNewProductTest extends BaseTest {

    private final String NAME_PRODUCT = "Black duck";
    private final String FILE_NAME = "black_duck.png";
    private final String CODE_PRODUCT = getRandomNumber(6);
    private final String QUANTITY = getRandomNumber(1);
    private final String DATE_VALID_FROM = "21042021";
    private final String DATE_VALID_TO = "01012022";
    private final String KEYWORDS = "duck";
    private final String SHORT_DESC = "Black duck";
    private final String DESCRIPTION = "This is a black duck, but it's actually a black cat. The impudent cat";
    private final String HEAD_TITLE = "BLACK DUCK";
    private final String META_DESCRIPTION = "black cat";
    private final String PRICE = getRandomNumber(3);

    public static String getRandomNumber(int length) { return RandomStringUtils.randomNumeric(length); }

    public File getFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        return file;
    }

    @Test
    public void addNewProductTest() throws InterruptedException {
        loginByAdmin();
        Thread.sleep(300);
        driver.findElement(By.cssSelector("a[href*='catalog&doc=catalog']")).click();
        driver.findElement(By.cssSelector("a[href*='edit_product']")).click();

        WebElement categoriesRubberDucks = driver.findElement(By.cssSelector("input[data-name='Rubber Ducks']"));
        String checkedRubberDucks = categoriesRubberDucks.getAttribute("checked");
        Thread.sleep(500);

        if (checkedRubberDucks != "false") {
           categoriesRubberDucks.click();
       }

        String filePath = getFile().getAbsolutePath();
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(filePath);

        Actions action = new Actions(driver);
        action.click()
                .click(driver.findElement(By.cssSelector("div#tab-general input[value='0']"))).sendKeys(Keys.TAB)
                .sendKeys(NAME_PRODUCT).sendKeys(Keys.TAB)
                .sendKeys(CODE_PRODUCT)
                .click(driver.findElement(By.cssSelector("select[name='default_category_id']"))).sendKeys("Rubber Ducks")
                .click(driver.findElement(By.cssSelector("input[value='1-3']")))
                .doubleClick(driver.findElement(By.cssSelector("input[name='quantity']"))).sendKeys(QUANTITY)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .moveToElement(driver.findElement(By.cssSelector("input[name='date_valid_from']"))).click()
                .sendKeys(DATE_VALID_FROM).sendKeys(Keys.TAB).sendKeys(DATE_VALID_TO)
                .click(driver.findElement(By.cssSelector("a[href*='information']")))
                .pause(500)
                .click(driver.findElement(By.cssSelector("select[name='manufacturer_id']"))).sendKeys("ACME Corp.")
                .click(driver.findElement(By.cssSelector("input[name='keywords']")))
                .sendKeys(KEYWORDS).sendKeys(Keys.TAB)
                .sendKeys(SHORT_DESC).sendKeys(Keys.TAB)
                .sendKeys(DESCRIPTION).sendKeys(Keys.TAB)
                .sendKeys(HEAD_TITLE).sendKeys(Keys.TAB)
                .sendKeys(META_DESCRIPTION)
                .click(driver.findElement(By.cssSelector("a[href*='prices']")))
                .pause(500)
                .doubleClick(driver.findElement(By.cssSelector("input[name='purchase_price']"))).sendKeys(PRICE)
                .click(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']"))).sendKeys("Euros")
                .doubleClick(driver.findElement(By.cssSelector("input[name='prices[USD]']"))).sendKeys(PRICE)
                .doubleClick(driver.findElement(By.cssSelector("input[name='prices[EUR]']"))).sendKeys(PRICE)
                .perform();

        driver.findElement(By.cssSelector("button[name='save']")).click();
    }
}
