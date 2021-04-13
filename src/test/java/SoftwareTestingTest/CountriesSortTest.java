package SoftwareTestingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountriesSortTest  extends BaseTest {

    @Test
    public void sortCountriesTest() {
        openCountriesPage();
        List<WebElement> listCountries = driver.findElements(By.cssSelector("tr.row a[href*=country_code]"));
        List<String> allCountries = new ArrayList<String>();
        for (WebElement row : listCountries){
            String nameCountry = row.getAttribute("innerText");
            if (!nameCountry.equals(""))
                allCountries.add(nameCountry);
        }
        for (int i =1; i<allCountries.size(); i++ ){
            String current = allCountries.get(i);
            String previous = allCountries.get(i-1);
            if (current.compareTo(previous) < 0){
                throw new RuntimeException();
            }
        }
    }
}
