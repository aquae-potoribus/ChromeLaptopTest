import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerPage {
    private final WebDriver driver;

    public ComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void laptopClick() {
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/ul/li[1]/div/a")).click();
    }
}
