package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class YellowDuckPriseTest extends BaseTest {

    private final String link = "div#box-campaigns a.link";

    @Test
    public void productNameTest() {
        openInMyStore();
        WebElement linkElement = driver.findElement(By.cssSelector(link));
        String nameWare = driver.findElement(By.cssSelector("div#box-campaigns div.name"))
                .getAttribute("textContent");
        String price = driver.findElement(By.cssSelector("div#box-campaigns div.price-wrapper"))
                .getAttribute("innerText");
        linkElement.click();
        wait.until(ExpectedConditions.titleIs("Yellow Duck | Subcategory | Rubber Ducks | My Store"));

        Assert.assertEquals(nameWare, driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent")); //a
        Assert.assertEquals(price, driver.findElement(By.cssSelector("div.price-wrapper")).getAttribute("innerText")); //б
    }

    @Test
    public void campaignsPriseTest(){
        openInMyStore();
        WebElement regularPriceElement = driver.findElement(By.cssSelector("div#box-campaigns .regular-price"));
        String colorRegularPrice = regularPriceElement.getCssValue("color");
        String tegRegularPrice = regularPriceElement.getAttribute("tagName");
        Dimension sizeRegularPrice = regularPriceElement.getSize();
        int heightRegularPrice = sizeRegularPrice.getHeight();
        int widthRegularPrice = sizeRegularPrice.getWidth();
        List<String> rgbaRegularPrice = Arrays.asList(colorRegularPrice.substring( 5, 19)
                .replaceAll("\\s", "").split(","));

        WebElement campaignPriceElement = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price"));
        String colorCampaignPrice = campaignPriceElement.getCssValue("color");
        String tegCampaignPrice = campaignPriceElement.getAttribute("tagName");
        Dimension sizeCampaignPrice = campaignPriceElement.getSize();
        int heightCampaignPrice = sizeCampaignPrice.getHeight();
        int widthCampaignPrice = sizeCampaignPrice.getWidth();
        List<String> rgbaCampaignPrice = Arrays.asList(colorCampaignPrice.substring( 5, 14)
                .replaceAll("\\s", "").split(","));

        Assert.assertEquals(rgbaRegularPrice.get(0),rgbaRegularPrice.get(1),rgbaRegularPrice.get(2));
        Assert.assertEquals(tegRegularPrice,"S");
        Assert.assertEquals(rgbaCampaignPrice.get(1),rgbaCampaignPrice.get(2), "0");
        Assert.assertEquals(tegCampaignPrice,"STRONG");
        Assert.assertTrue(heightCampaignPrice > heightRegularPrice || widthCampaignPrice > widthRegularPrice);
    }

    @Test
    public void yellowDuckPriseTest() {
        openInMyStore();
        WebElement linkElement = driver.findElement(By.cssSelector(link));
        linkElement.click();
        wait.until(ExpectedConditions.titleIs("Yellow Duck | Subcategory | Rubber Ducks | My Store"));

        WebElement regularElement = driver.findElement(By.cssSelector("div.price-wrapper .regular-price"));
        String colorRegular = regularElement.getCssValue("color");
        String tegRegular = regularElement.getAttribute("tagName");
        List<String> rgbaRegular = Arrays.asList(colorRegular.substring( 5, 19)
                .replaceAll("\\s", "").split(","));
        Dimension sizeRegular = regularElement.getSize();
        int heightRegular = sizeRegular.getHeight();
        int widthRegular = sizeRegular.getWidth();

        WebElement campaignElement = driver.findElement(By.cssSelector("div.price-wrapper .campaign-price"));
        String colorCampaign = campaignElement.getCssValue("color");
        String tegCampaign = campaignElement.getAttribute("tagName");
        List<String> rgbaCampaign = Arrays.asList(colorCampaign.substring( 5, 14)
                .replaceAll("\\s", "").split(","));
        Dimension sizeCampaign = campaignElement.getSize();
        int heightCampaign = sizeCampaign.getHeight();
        int widthCampaign = sizeCampaign.getWidth();

        Assert.assertEquals(rgbaRegular.get(0),rgbaRegular.get(1),rgbaRegular.get(2));
        Assert.assertEquals(tegRegular,"S");
        Assert.assertEquals(rgbaCampaign.get(1),rgbaCampaign.get(2), "0");
        Assert.assertEquals(tegCampaign,"STRONG");
        Assert.assertTrue(heightCampaign > heightRegular || widthCampaign > widthRegular);
    }
}
