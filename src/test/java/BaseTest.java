import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    public String songName= "Dark Days";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
            driver.quit();
    }

    public void navigateToPage() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    }
    public void provideEmail() throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("anastasia.dovhal@testpro.io");
        Thread.sleep(2000);
    }
    public void providePassword() throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);
    }
    public void clickSubmitButton() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public void openSearchField() throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//*[@id='searchForm']/input"));
        searchField.clear();
        searchField.click();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }
    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
        viewAllButton.click();
        Thread.sleep(2000);
    }
    public void clickTheFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddTo() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void selectPlaylist() throws InterruptedException {
        WebElement playlistLoo = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[6]"));
        playlistLoo.click();
        Thread.sleep(2000);
    }
        public String getNotificationText() throws InterruptedException {
                WebElement AddingSongToPlaylistNotification = driver.findElement(By.cssSelector("div.success.show"));
                Thread.sleep(2000);
                return AddingSongToPlaylistNotification.getText();
            }
    }

