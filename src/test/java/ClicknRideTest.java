import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;

@Test
public class ClicknRideTest {
    private WebElement dbLoginBox;
    public void urlReachable() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Users/ryanki10/downloads/drivers/chrome/driver80/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://clickandride.dbnetze.com/");
        dbLoginBox = driver.findElement(By.className("db-login-box"));
        assertEquals(dbLoginBox.isDisplayed(), true);
    }
}