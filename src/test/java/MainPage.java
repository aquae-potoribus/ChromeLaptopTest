import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://market.yandex.ru/");
    }

    public void catalogClick() {
        driver.findElement(By.id("catalogPopupButton")).click();
    }

    public void computersClick() {
        driver.findElements(By.className("_191Hm")).get(3).click();
    }

}
