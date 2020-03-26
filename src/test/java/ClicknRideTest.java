import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://clickandride.dbnetze.com/");
        dbLoginBox = driver.findElement(By.className("db-login-box"));
        assertEquals(dbLoginBox.isDisplayed(), true);
        WebElement eleUser = driver.findElement(By.cssSelector(".item-user .text-input"));
        eleUser.sendKeys("cnr");
        WebElement elePassword = driver.findElement(By.cssSelector(".item-password .text-input"));
        elePassword.sendKeys("cnr");
        WebElement eleLogin = driver.findElement(By.cssSelector(".dbLoginButton"));
        eleLogin.click();
        String expectedText = "Anmeldedaten sind ungültig oder Passwort ist abgelaufen";
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector(".validation-error"), expectedText));
    }
}