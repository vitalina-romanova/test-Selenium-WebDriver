package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CartWorkTest extends BaseTest {

    private final String BUTTON_ADD_PRODUCT = "button[name='add_cart_product']";
    private final String MY_STORE_MAIN_PAGE = "a[href='http://localhost/litecart/en/']";
    private  String PRODUCT = "li[class='product column shadow hover-light']";

    @Test
    public void cartWorkTest() throws InterruptedException {
        openMyStore();
        List<WebElement> product = driver.findElements(By.cssSelector(PRODUCT));
        for (int i=0; i<3; i++) {
            WebElement current = product.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(current));
            current.click();
            try {
                WebElement select = driver.findElement(By.cssSelector("select[name='options[Size]']"));
                select.click();
                driver.findElement(By.cssSelector("option[value='Small']")).click();
            }
            catch (NoSuchElementException ex) { }

                driver.findElement(By.cssSelector(BUTTON_ADD_PRODUCT)).click();
                WebElement cart = driver.findElement(By.cssSelector("span[class='quantity']"));
                int item = Integer.parseInt(cart.getAttribute("textContent"));
                wait.until(ExpectedConditions.attributeToBe(cart, "textContent", String.valueOf(item + 1)));
                driver.findElement(By.cssSelector(MY_STORE_MAIN_PAGE)).click();
                wait.until(ExpectedConditions.titleIs("Online Store | My Store"));
                product = driver.findElements(By.cssSelector(PRODUCT));
        }

//        WebDriverWait wait = new WebDriverWait(driver, 500);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("a.link[href*='/checkout']")).click();
        wait.until(ExpectedConditions.titleIs("Checkout | My Store"));
        driver.findElement(By.cssSelector("div#box-checkout-cart")).click();
        Thread.sleep(500);

        List<WebElement> items = driver.findElements(By.cssSelector("button[name='remove_cart_item']"));
        for (int j=0; j<items.size(); j++){
            WebElement item = driver.findElement(By.cssSelector("button[name='remove_cart_item']"));
            WebElement orderSummary = driver.findElement(By.cssSelector("table[class='dataTable rounded-corners']"));
            wait.until(ExpectedConditions.elementToBeClickable(item)).click();
            wait.until(ExpectedConditions.stalenessOf(orderSummary));
        }
    }
}
