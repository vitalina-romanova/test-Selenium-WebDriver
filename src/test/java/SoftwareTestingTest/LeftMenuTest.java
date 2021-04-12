package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuTest extends BaseTest{

    private final String selectorH1 = "#content h1";

    @Test
    public void leftMenuTest() throws InterruptedException {
        List<String> selectors = new ArrayList<String>();
        selectors.add("a[href*='appearance&doc=template']");
        selectors.add("a[href*='appearance&doc=logotype']");
        selectors.add("a[href*='catalog&doc=catalog']");
        selectors.add("a[href*='catalog&doc=product_groups']");
        selectors.add("a[href*='catalog&doc=option_groups']");
        selectors.add("a[href*='catalog&doc=manufacturers']");
        selectors.add("a[href*='catalog&doc=suppliers']");
        selectors.add("a[href*='catalog&doc=delivery_statuses']");
        selectors.add("a[href*='catalog&doc=sold_out_statuses']");
        selectors.add("a[href*='catalog&doc=quantity_units']");
        selectors.add("a[href*='catalog&doc=csv']");
        selectors.add("a[href*='countries']");
        selectors.add("a[href*='currencies']");
        selectors.add("a[href*='customers&doc=customers']");
        selectors.add("a[href*='customers&doc=csv']");
        selectors.add("a[href*='customers&doc=newsletter']");
        selectors.add("a[href*='geo_zones&doc=geo_zones']");
        selectors.add("a[href*='languages&doc=languages']");
        selectors.add("a[href*='languages&doc=storage_encoding']");
        selectors.add("a[href*='modules&doc=jobs']");
        selectors.add("a[href*='app=modules&doc=customer']");
        selectors.add("a[href*='modules&doc=shipping']");
        selectors.add("a[href*='modules&doc=payment']");
        selectors.add("a[href*='modules&doc=order_total']");
        selectors.add("a[href*='modules&doc=order_success']");
        selectors.add("a[href*='modules&doc=order_action']");
        selectors.add("a[href*='orders']");
        selectors.add("a[href*='orders&doc=order_statuses']");
        selectors.add("a[href*='pages']");
        selectors.add("a[href*='reports&doc=monthly_sales']");
        selectors.add("a[href*='reports&doc=most_sold_products']");
        selectors.add("a[href*='reports&doc=most_shopping_customers']");
        selectors.add("a[href*='settings&doc=store_info']");
        selectors.add("a[href*='settings&doc=defaults']");
        selectors.add("a[href*='settings&doc=general']");
        selectors.add("a[href*='settings&doc=listings']");
        selectors.add("a[href*='settings&doc=images']");
        selectors.add("a[href*='settings&doc=checkout']");
        selectors.add("li a[href*='settings&doc=advanced']");
        selectors.add("a[href*='settings&doc=security']");
        selectors.add("a[href*='slides']");
        selectors.add("a[href*='tax&doc=tax_classes']");
        selectors.add("a[href*='tax&doc=tax_rates']");
        selectors.add("a[href*='translations']");
        selectors.add("a[href*='translations&doc=search']");
        selectors.add("a[href*='translations&doc=scan']");
        selectors.add("a[href*='translations&doc=csv']");
        selectors.add("a[href*='users']");
        selectors.add("a[href*='vqmods']");

        loginByAdmin();
        for (String selector : selectors){
            WebElement header = findHeader(selector);
            Assert.assertTrue(header.isDisplayed());
        }
    }

    private WebElement findHeader(String selector) throws InterruptedException {
        WebElement logotype = driver.findElement(By.cssSelector(selector));
        Thread.sleep(800);
        logotype.click();
        return driver.findElement(By.cssSelector(selectorH1));
    }
}
