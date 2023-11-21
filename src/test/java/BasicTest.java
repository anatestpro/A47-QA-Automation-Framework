import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BasicTest {
        public WebDriver driver = null;
        public String url = "https://qa.koel.app/";
        public String songName = "Dark Days";

        public BasicTest() {
        }

        @BeforeSuite
        static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeMethod
        public void launchBrowser() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--remote-allow-origins=*"});
            this.driver = new ChromeDriver(options);
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
            this.driver.manage().window().maximize();
        }

        @AfterMethod
        public void closeBrowser() {
            this.driver.quit();
        }

        public void navigateToPage() throws InterruptedException {
            this.driver.get(this.url);
            Thread.sleep(2000L);
        }

        public void provideEmail() throws InterruptedException {
            WebElement emailField = this.driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(new CharSequence[]{"anastasia.dovhal@testpro.io"});
            Thread.sleep(2000L);
        }

        public void providePassword() throws InterruptedException {
            WebElement passwordField = this.driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(new CharSequence[]{"te$t$tudent"});
            Thread.sleep(2000L);
        }

        public void clickSubmitButton() throws InterruptedException {
            WebElement submitButton = this.driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
            Thread.sleep(2000L);
        }

        public void openSearchField() throws InterruptedException {
            WebElement searchField = this.driver.findElement(By.xpath("//*[@id='searchForm']/input"));
            searchField.clear();
            searchField.click();
            searchField.sendKeys(new CharSequence[]{this.songName});
            Thread.sleep(2000L);
        }

        public void clickViewAllButton() throws InterruptedException {
            WebElement viewAllButton = this.driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
            viewAllButton.click();
            Thread.sleep(2000L);
        }

        public void clickTheFirstSong() throws InterruptedException {
            WebElement firstSong = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
            firstSong.click();
            Thread.sleep(2000L);
        }

        public void clickAddTo() throws InterruptedException {
            WebElement addToButton = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
            addToButton.click();
            Thread.sleep(2000L);
        }

        public void selectPlaylist() throws InterruptedException {
            WebElement playlistLoo = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[6]"));
            playlistLoo.click();
            Thread.sleep(2000L);
        }

        public String getNotificationText() throws InterruptedException {
            WebElement AddingSongToPlaylistNotification = this.driver.findElement(By.cssSelector("div.success.show"));
            Thread.sleep(2000L);
            return AddingSongToPlaylistNotification.getText();
        }

        public void clickPlayNextSong() throws InterruptedException {
            WebElement playNextSOngButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
            playNextSOngButton.click();
        }
        public void clickPlayButton() throws InterruptedException {
            WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]/i"));
            playButton.click();
        }
    }

