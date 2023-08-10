import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static Actions actions = null;
    public static String newPlaylistName = "ZUMBA";

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

        threadDriver.set(pickBrowser(System.getProperty("browser", "chrome")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(driver);
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
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();

        //actions.doubleClick(emailField).perform();
        //actions.doubleClick(driver.findElement(By.cssSelector(".method"))).perform();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        submitButton.click();
    }
    public void openPlaylist(){
        WebElement zumbaPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
   zumbaPlaylist.click();
    }
    public void  doubleClickPlaylist(){
        WebElement annnPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        actions.doubleClick(annnPlaylist).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistNameInputField.sendKeys(newPlaylistName);
        playlistNameInputField.sendKeys(Keys.ENTER);
    }

    public boolean playlistExists(){
       WebElement renamedPlaylistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
       return renamedPlaylistElement.isDisplayed();
    }


    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }
}
