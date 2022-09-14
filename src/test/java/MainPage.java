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
        driver.findElement(By.xpath("//button[@id='catalogPopupButton']")).click();
    }

    public void computersClick() {
        driver.findElement(By.xpath("//*[@id=\"catalogPopup\"]/div/div/div/div/div/div/div[1]/ul/li[4]/a")).click();
    }

}
