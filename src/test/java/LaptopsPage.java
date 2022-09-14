import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaptopsPage {

    private final WebDriver driver;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LenovoFilterClick() {
        driver.findElement(By.cssSelector("label[data-auto='filter-list-item-152981']")).click();
    }

    public void printMinPriceFilter(String minPrice) {
        WebElement min = driver.findElements(By.cssSelector("input[class='_3qxDp']")).get(0);
        min.click();
        min.sendKeys(minPrice);
    }

    public void printMaxPriceFilter(String maxPrice) {
        WebElement max = driver.findElements(By.cssSelector("input[class='_3qxDp']")).get(1);
        max.click();
        max.sendKeys(maxPrice);
    }

    public void scrollToBottom() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void checkResultListForConditions(int minPrice, int maxPrice, String brand) throws Exception {
        List<WebElement> laptopElements = driver.findElements(By.cssSelector("div[data-tid='5c8f99e1']"));
        for (WebElement laptopElement : laptopElements) {
            String priceString = laptopElement.findElement(By.cssSelector(("span[data-auto='mainPrice']"))).findElement(By.tagName("span")).getText();
            String nameString = laptopElement.findElement(By.cssSelector(("span[data-tid='2e5bde87']"))).getText();
            int price = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
            if (price < minPrice || price > maxPrice) {
                throw new Exception("the price should not go out of range");
            }
            if (!nameString.toLowerCase().contains(brand)) {
                throw new Exception("laptop must be lenovo brand");
            }
        }
    }


}
