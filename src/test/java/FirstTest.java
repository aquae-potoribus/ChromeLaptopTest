import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {
    @Test
    public void firstTest() throws Exception {

        int minPrice = 25000;
        int maxPrice = 30000;
        String brand = "lenovo";
        String chromedriverLocation = "C:\\Programming\\chromeDriver\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        ComputerPage computerPage = new ComputerPage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);

        mainPage.openMainPage();
        Thread.sleep(7000);
        waitSec();
        mainPage.catalogClick();
        waitSec();
        mainPage.computersClick();
        waitSec();
        computerPage.laptopClick();
        waitSec();
        laptopsPage.LenovoFilterClick();
        waitSec();
        laptopsPage.printMinPriceFilter(String.valueOf(minPrice));
        laptopsPage.printMaxPriceFilter(String.valueOf(maxPrice));
        waitSec();
        laptopsPage.scrollToBottom();
        waitSec();

        laptopsPage.checkResultListForConditions(minPrice, maxPrice, brand);
        driver.quit();
    }

    public void waitSec() throws InterruptedException {
        Thread.sleep(1500);
    }
}
