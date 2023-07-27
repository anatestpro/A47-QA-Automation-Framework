import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    public static String email = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public static void clickAvatarIcon(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        avatarIcon.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[id='inputProfileName']"));
        profileName.clear();
        profileName.click();
        profileName.sendKeys(randomName);
    }
    public static void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("[class='btn-submit']"));
        saveButton.click();
        }

        public static String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
        }

        public static void searchForSong(String song){
        WebElement searchButton = driver.findElement(By.cssSelector("[type='search']"));
        searchButton.clear();
        searchButton.click();
        searchButton.sendKeys(song);
        }

        public static void clickViewAll(){
        WebElement viewAllButton = driver.findElement(By.cssSelector("[class='songs']>h1>button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        }

        public static void selectTheFirstSong(){
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
        }

        public static void clickAddToButton(){
        WebElement addToButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        addToButton.click();
        }

        public static void chooseZumbaPlaylist(){
        WebElement zumbaPlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[6]"));
        zumbaPlaylist.click();
        }

        public String getNotificationText(){
        WebElement AddingSongToPlaylistNotification = driver.findElement(By.cssSelector("[class='success show]"));
        return AddingSongToPlaylistNotification.getText();
        }
        @AfterMethod
                public void closeBrowser(){
                driver.quit();
}
    }

