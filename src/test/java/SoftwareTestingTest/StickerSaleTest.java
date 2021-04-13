package SoftwareTestingTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StickerSaleTest extends BaseTest {

    @Test
    public void stickersFindTest() {
        openInMyStore();
        List<WebElement> items = driver.findElements(By.cssSelector("a.link[href*='rubber-ducks']"));
        for (WebElement element : items) {
            List<WebElement> stickers = element.findElements(By.cssSelector("div[class *= 'sticker']"));
            Assert.assertEquals(stickers.size(), 1);
        }
    }
}