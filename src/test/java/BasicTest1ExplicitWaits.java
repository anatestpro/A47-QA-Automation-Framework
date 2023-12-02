import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTest1ExplicitWaits {
    public WebDriver driver = null;
    public static WebDriverWait wait = null;

    public String url = "https://qa.koel.app/";
    public String songName = "Dark Days";

        public BasicTest1ExplicitWaits(){
        }

        @BeforeSuite
        static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeMethod
        @Parameters({"BaseURL"})

        public void launchBrowser (String BaseURL){
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--remote-allow-origins=*"});
            this.driver = new ChromeDriver(options);
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));

            url = BaseURL;
            driver.get(url);
            //launching implicit wait method
            wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        }

        @AfterMethod
        public void closeBrowser () {
            this.driver.quit();
        }

        @DataProvider(name = "IncorrectLoginData")
        public static Object[][] getDataFromDataProviders () {
            return new Object[][]{
                    {"invalid@mail.com", "invalidPassword"},
                    {"demo@class.com", ""},
                    {"", ""}
            };
        }


        public void provideEmail (String email){
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(email);
        }

        public void providePassword (String password){
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(password);
        }

        public void clickSubmitButton () {
            WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
            submitButton.click();

        }

        public void openSearchField () {
            WebElement searchField = this.driver.findElement(By.xpath("//*[@id='searchForm']/input"));
            searchField.clear();
            searchField.click();
            searchField.sendKeys(songName);

        }

        public void clickViewAllButton () {
            WebElement viewAllButton = this.driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
            viewAllButton.click();

        }

        public void clickTheFirstSong () {
            WebElement firstSong = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
            firstSong.click();

        }

        public void clickAddTo () {
            WebElement addToButton = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
            addToButton.click();

        }

        public void selectPlaylist () {
            WebElement playlistLoo = this.driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[6]"));
            playlistLoo.click();

        }

        public String getNotificationText () {
            WebElement AddingSongToPlaylistNotification = this.driver.findElement(By.cssSelector("div.success.show"));

            return AddingSongToPlaylistNotification.getText();
        }

        public void clickPlayNextSong () {
            WebElement playNextSOngButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
            playNextSOngButton.click();
        }
        public void clickPlayButton () {
            WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]/i"));
            playButton.click();
        }
        public void choosePlaylist () {
            WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            playlist.click();
        }
        public void clickDeletePlaylistButton () {
            WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
            deletePlaylistButton.click();
        }
            public String DeletedPlaylistMessage(){
                WebElement deletedPlaylistNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
                return deletedPlaylistNotification.getText();
            }

        }

