import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

        threadDriver.set(pickBrowser(System.getProperty("browser", "chrome")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }
        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return driver = new ChromeDriver(options);
        }


    public void navigateToPage(){
        driver.get(url);
    }
    public void  provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }
    public void openPlaylist(){
        WebElement zumbaPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
   zumbaPlaylist.click();
    }
    public void ClickDeletePlaylistButton(){
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button.del.btn-delete-playlist"));
   deletePlaylistButton.click();
   WebElement confirmToDeletePlaylist = driver.findElement(By.cssSelector("body > div.alertify > div > div > nav > button.ok"));
   confirmToDeletePlaylist.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
    return notificationMsg.getText();
    }
    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }
}
