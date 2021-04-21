package SoftwareTestingTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class AddNewProductTest extends BaseTest {

    private final String NAME_PRODUCT = "Black duck";
    private final String FILE_NAME = "black_duck.png";
    private final String CODE_PRODUCT = getRandomNumber(6);
    private final String QUANTITY = getRandomNumber(1);

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
        WebElement status = driver.findElement(By.cssSelector("div#tab-general input[value='1']"));
    //       Thread.sleep(300);
        WebElement categoriesRubberDucks = driver.findElement(By.cssSelector("input[data-name='Rubber Ducks']"));
        String checkedRubberDucks = categoriesRubberDucks.getAttribute("checked");
        Thread.sleep(700);
        if (checkedRubberDucks != "false") {
           categoriesRubberDucks.click();
           driver.findElement(By.cssSelector("select[name='default_category_id']")).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='1']"))).click();
       }

        String filePath = getFile().getAbsolutePath();
        Actions action = new Actions(driver);
        action.click()
           .click(status).sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys(NAME_PRODUCT).sendKeys(Keys.TAB)
                .sendKeys(CODE_PRODUCT).sendKeys(Keys.TAB)
                .moveToElement(driver.findElement(By.cssSelector("input[value='1-3']"))).click()
                .moveToElement(driver.findElement(By.cssSelector("input[name='quantity']"))).doubleClick()
                .sendKeys(QUANTITY).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .moveToElement(driver.findElement(By.cssSelector("input[name='date_valid_from']")), 75, 0)
                .click()
                .perform();

        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(filePath);
    }
}
