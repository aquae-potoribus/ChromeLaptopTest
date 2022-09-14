import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerPage {
    private final WebDriver driver;

    public ComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void laptopClick() {
        driver.findElements(By.cssSelector("a[class='egKyN _2oLyz _9qbcy']")).get(0).click();
    }
}
