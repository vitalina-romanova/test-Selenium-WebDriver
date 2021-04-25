package SoftwareTestingTest;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class NewWindowTest extends BaseTest {

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return driver -> {
            Set<String> handles = BaseTest.driver.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }

    @Test
    public void newWindowTest(){
     loginByAdmin();
     driver.findElement(By.cssSelector("a[href*='doc=countries']")).click();
     driver.findElement(By.cssSelector("a[href*='doc=edit_country']")).click();
        wait.until(ExpectedConditions.titleIs("Add New Country | My Store"));
        String mainWindow = driver.getWindowHandle();

        List<WebElement> faExternalLink = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        for (WebElement element : faExternalLink){
            Set<String> existingWindows = driver.getWindowHandles();
            element.click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
