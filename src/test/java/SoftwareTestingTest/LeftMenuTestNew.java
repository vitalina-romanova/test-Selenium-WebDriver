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
        List<WebElement> menu = driver.findElements(By.cssSelector("li#app-"));
        int sizeMenu = menu.size();
        for (int i=0; i<sizeMenu; i++) {
            WebElement current = menu.get(i);
            Thread.sleep(500);
            current.click();
            List<WebElement> subMenu = driver.findElements(By.cssSelector("li[id^='doc-']"));
            int sizeSubMenu = subMenu.size();
            if (subMenu.size() > 0 ){
                for (int j=0; j<sizeSubMenu; j++) {
                    WebElement doc = subMenu.get(j);
                    Thread.sleep(500);
                    doc.click();
                    WebElement header = driver.findElement(By.cssSelector(selectorH1));
                    Assert.assertTrue(header.isDisplayed());
                    subMenu = driver.findElements(By.cssSelector("li[id^='doc-']"));
                }
                menu = driver.findElements(By.id("app-"));
            }
            else {
                WebElement header = driver.findElement(By.cssSelector(selectorH1));
                Assert.assertTrue(header.isDisplayed());
                menu = driver.findElements(By.id("app-"));
            }
        }
    }
}

