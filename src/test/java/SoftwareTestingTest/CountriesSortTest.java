package SoftwareTestingTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CountriesSortTest  extends BaseTest {


    private void assertABC(List<String> strings){
        for (int i =1; i<strings.size(); i++ ){
            String current = strings.get(i);
            String previous = strings.get(i-1);
            Assert.assertTrue(current.compareTo(previous) > 0);
        }
    }

    @Test
    public void sortCountriesTest() {
        openCountriesPage();
        List<WebElement> rowCountries = driver.findElements(By.cssSelector("tr.row"));
        List<String> allCountries = new ArrayList<String>();
        int size = rowCountries.size();
        for (int i = 0; i < size; i++) {
            WebElement countryElement = rowCountries.get(i).findElement(By.cssSelector("td:nth-child(5) a"));
            String nameCountry = countryElement.getAttribute("innerText");
            allCountries.add(nameCountry);
            WebElement zoneElement = rowCountries.get(i).findElement(By.cssSelector("td:nth-child(6)"));
            String count = zoneElement.getAttribute("innerText");

            if (!count.equals("0")) {
                countryElement.click();
                wait.until(ExpectedConditions.titleIs("Edit Country | My Store"));
                List<WebElement> zoneElements = driver.findElements(By.cssSelector("input[name*='[name]']:not([type='text'])"));
                List<String> allZones = new ArrayList<String>();
                for (WebElement zone : zoneElements) {
                    String nameZone = zone.getAttribute("value");
                    allZones.add(nameZone);
                }
                assertABC(allZones);
                driver.navigate().back();
                rowCountries = driver.findElements(By.cssSelector("tr.row"));
                System.out.println(allZones);
            }
        }
        assertABC(allCountries);
        System.out.println(allCountries);
    }
}
