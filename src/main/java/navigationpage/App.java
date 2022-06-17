package navigationpage;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = getWebDriverOnOpenCart();
        sleepForSeconds(3);
        searchProduct(driver);
        sleepForSeconds(3);
        deletedModal(driver);
        sleepForSeconds(5);
        clickProductToCart(driver);
        sleepForSeconds(10);
        driver.close();
    }

    private static WebDriver getWebDriverOnOpenCart(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.plazavea.com.pe/");
        return driver;
    }

    private static void searchProduct(WebDriver driver){
        WebElement SearchFieldProduct = driver.findElement(By.id("search_box"));
        SearchFieldProduct.sendKeys("Arroz costeño" + Keys.ENTER);
    }

    private static void deletedModal(WebDriver driver){
        WebElement closeModal = driver.findElement(By.cssSelector("img.CustomModal__close"));
        closeModal.click();
    }

    private static void clickProductToCart(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By xpath = By.xpath("//a[text()='Arroz Superior COSTEÑO Bolsa 750g']");
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
    }

    private static void sleepForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            System.out.println("sleepForSeconds interrupted!");
        }
    }
}
