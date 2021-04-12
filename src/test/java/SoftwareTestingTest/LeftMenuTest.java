package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LeftMenuTest extends BaseTest{

    private final String selectorTemplate = "a[href*='appearance&doc=template']";
    private final String selectorLogotype = "a[href*='appearance&doc=logotype']";
    private final String selectorCatalog = "a[href*='catalog&doc=catalog']";
    private final String selectorProductGroups = "a[href*='catalog&doc=product_groups']";
    private final String selectorOptionGroups = "a[href*='catalog&doc=option_groups']";
    private final String selectorManufacturers = "a[href*='catalog&doc=manufacturers']";
    private final String selectorSuppliers = "a[href*='catalog&doc=suppliers']";
    private final String selectorDeliveryStatuses = "a[href*='catalog&doc=delivery_statuses']";
    private final String selectorSoldOutStatuses = "a[href*='catalog&doc=sold_out_statuses']";
    private final String selectorQuantityUnits = "a[href*='catalog&doc=quantity_units']";
    private final String selectorCatalogCSV = "a[href*='catalog&doc=csv']";
    private final String selectorCountries = "a[href*='countries']";
    private final String selectorCurrencies = "a[href*='currencies']";
    private final String selectorCustomers = "a[href*='customers&doc=customers']";
    private final String selectorCustomersCSV = "a[href*='customers&doc=csv']";
    private final String selectorNewsletter = "a[href*='customers&doc=newsletter']";
    private final String selectorGeoZones = "a[href*='geo_zones&doc=geo_zones']";
    private final String selectorLanguages = "a[href*='languages&doc=languages']";
    private final String selectorStorageEncoding = "a[href*='languages&doc=storage_encoding']";
    private final String selectorModules = "a[href*='modules&doc=jobs']";
    private final String selectorCustomer = "a[href*='app=modules&doc=customer']";
    private final String selectorShipping = "a[href*='modules&doc=shipping']";
    private final String selectorPayment = "a[href*='modules&doc=payment']";
    private final String selectorOrderTotal = "a[href*='modules&doc=order_total']";
    private final String selectorOrderSuccess = "a[href*='modules&doc=order_success']";
    private final String selectorOrderAction = "a[href*='modules&doc=order_action']";
    private final String selectorOrders = "a[href*='orders']";
    private final String selectorOrderStatuses = "a[href*='orders&doc=order_statuses']";
    private final String selectorPages = "a[href*='pages']";
    private final String selectorReports = "a[href*='reports&doc=monthly_sales']";
    private final String selectorMostSoldProduct = "a[href*='reports&doc=most_sold_products']";
    private final String selectorMostShipping = "a[href*='reports&doc=most_shopping_customers']";
    private final String selectorStoreInfo = "a[href*='settings&doc=store_info']";
    private final String selectorDefaults = "a[href*='settings&doc=defaults']";
    private final String selectorGeneral = "a[href*='settings&doc=general']";
    private final String selectorListings = "a[href*='settings&doc=listings']";
    private final String selectorImages = "a[href*='settings&doc=images']";
    private final String selectorCheckout = "a[href*='settings&doc=checkout']";
    private final String selectorAdvanced = "li a[href*='settings&doc=advanced']";
    private final String selectorSecurity = "a[href*='settings&doc=security']";
    private final String selectorSlides = "a[href*='slides']";
    private final String selectorTaxClasses = "a[href*='tax&doc=tax_classes']";
    private final String selectorTaxRates = "a[href*='tax&doc=tax_rates']";
    private final String selectorTranslations = "a[href*='translations']";
    private final String selectorSearch = "a[href*='translations&doc=search']";
    private final String selectorScanFiles = "a[href*='translations&doc=scan']";
    private final String selectorTranslationsCVS = "a[href*='translations&doc=csv']";
    private final String selectorUsers = "a[href*='users']";
    private final String selectorVQmods = "a[href*='vqmods']";
    private final String selectorH1 = "#content h1";

    @Test
    public void leftMenuTests() throws InterruptedException {
        loginByAdmin();
        WebElement header = findHeader(selectorTemplate);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorLogotype);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCatalog);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorProductGroups);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOptionGroups);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorManufacturers);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorSuppliers);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorDeliveryStatuses);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorSoldOutStatuses);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorQuantityUnits);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCatalogCSV);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCountries);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCurrencies);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCustomers);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCustomersCSV);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorNewsletter);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorGeoZones);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorLanguages);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorStorageEncoding);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorModules);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCustomer);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorShipping);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorPayment);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOrderTotal);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOrderSuccess);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOrderAction);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOrders);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorOrderStatuses);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorPages);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorReports);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorMostSoldProduct);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorMostShipping);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorStoreInfo);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorDefaults);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorGeneral);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorListings);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorImages);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorCheckout);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorAdvanced);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorSecurity);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorSlides);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorTaxClasses);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorTaxRates);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorTranslations);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorSearch);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorScanFiles);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorTranslationsCVS);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorUsers);
        Assert.assertTrue(header.isDisplayed());

        header = findHeader(selectorVQmods);
        Assert.assertTrue(header.isDisplayed());
    }

    private WebElement findHeader(String selector) throws InterruptedException {
        WebElement logotype = driver.findElement(By.cssSelector(selector));
        Thread.sleep(800);
        logotype.click();
        return driver.findElement(By.cssSelector(selectorH1));
    }
}
