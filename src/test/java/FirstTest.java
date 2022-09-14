import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FirstTest {

    @Test
    public void firstTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Programming\\chromeDriver");  // chromedriver location
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://market.yandex.ru/");
        Thread.sleep(7000);

        driver.findElementById("catalogPopupButton").click();
        waitSec();
        driver.findElementsByClassName("_191Hm").get(3).click();
        waitSec();
        driver.findElementsByCssSelector("a[class='egKyN _2oLyz _9qbcy']").get(0).click();
        waitSec();
        driver.findElementByCssSelector("label[data-auto='filter-list-item-152981']").click();
        waitSec();
        WebElement min = driver.findElementsByCssSelector("input[class='_3qxDp']").get(0);
        min.click();
        min.sendKeys("25000");
        WebElement max = driver.findElementsByCssSelector("input[class='_3qxDp']").get(1);
        max.click();
        max.sendKeys("30000");
        waitSec();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        waitSec();

        List<WebElement> laptopElements = driver.findElementsByCssSelector("div[data-tid='5c8f99e1']");
        for (WebElement laptopElement : laptopElements) {
            String priceString = laptopElement.findElement(By.cssSelector(("span[data-auto='mainPrice']"))).findElement(By.tagName("span")).getText();
            String nameString = laptopElement.findElement(By.cssSelector(("span[data-tid='2e5bde87']"))).getText();
            int price = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
            if (price < 25000 || price > 30000 ) {
                throw new Exception("the price should not go out of range");
            }
            if (!nameString.toLowerCase().contains("lenovo")) {
                throw new Exception("laptop must be lenovo brand");
            }
        }
        driver.quit();
    }

    public void waitSec() throws InterruptedException {
        Thread.sleep(1000);
    }
}
