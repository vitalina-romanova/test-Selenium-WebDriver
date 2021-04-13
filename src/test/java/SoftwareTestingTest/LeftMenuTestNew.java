package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LeftMenuTestNew extends BaseTest {

    private final String selectorH1 = "#content h1";

    @Test
    public void leftMenuTest() throws InterruptedException {
        loginByAdmin();
        List<WebElement> menu = driver.findElements(By.cssSelector("li#app-"));
        int size = menu.size();
        for (int i=0; i<size; i++) {
            WebElement current = menu.get(i);
            Thread.sleep(500);
            current.click();
            WebElement header = driver.findElement(By.cssSelector(selectorH1));
            Assert.assertTrue(header.isDisplayed());
            menu = driver.findElements(By.id("app-"));
        }
    }

//    private WebElement findHeader(String selector) throws InterruptedException {
//        WebElement logotype = driver.findElement(By.cssSelector(selector));
//        Thread.sleep(800);
//        logotype.click();
//        return driver.findElement(By.cssSelector(selectorH1));
//    }
}

