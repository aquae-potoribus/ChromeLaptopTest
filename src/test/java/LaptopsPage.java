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
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div[5]/div/div/div/div/div/div[2]/div/div[4]/div/div/div/div/div[4]/div/fieldset/div/div/div/div/div/div/div[5]/label")).click();
    }

    public void printMinPriceFilter(String minPrice) {
        WebElement min = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div[5]/div/div/div/div/div/div[2]/div/div[4]/div/div/div/div/div[1]/div/fieldset/div/div/div/span[1]/div/div/input"));
        min.click();
        min.sendKeys(minPrice);
    }

    public void printMaxPriceFilter(String maxPrice) {
        WebElement max = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div[5]/div/div/div/div/div/div[2]/div/div[4]/div/div/div/div/div[1]/div/fieldset/div/div/div/span[2]/div/div/input"));
        max.click();
        max.sendKeys(maxPrice);
    }

    public void scrollToBottom() {
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void checkResultListForConditions(int minPrice, int maxPrice, String brand) throws Exception {
        List<WebElement> laptopElements = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div[5]/div/div/div/div/div/div[1]/div/div[6]/div/div/div/div/main/div/div/div/div/div/div/div/div/div/article"));
        for (WebElement laptopElement : laptopElements) {
            String priceString = laptopElement.findElement(By.xpath((".//div[4]/div[1]/div[1]/div/a/div/span/span[1]"))).getText();
            String nameString = laptopElement.findElement(By.xpath((".//div[3]/div[1]/h3/a/span"))).getText();
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
