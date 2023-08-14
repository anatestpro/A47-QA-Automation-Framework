package BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator){
        return
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    By allSongs = By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a");
    // Play song methods
    public void chooseAllSongslist(){
        findElement(allSongs).click();
    }

    public void contextClick(By locator) {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(contextElement).perform();
    }
}
