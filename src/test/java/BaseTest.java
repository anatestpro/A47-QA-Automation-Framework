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

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

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
    public void navigateToPage(){
        driver.get(url);
    }
    public void  provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("#app > div > form > input[type=email]:nth-child(2)"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("#app > div > form > input[type=password]:nth-child(3)"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement submitButton = driver.findElement(By.cssSelector("#app > div > form > button"));
        submitButton.click();
    }
    public void clickPlayButton(){
        WebElement playNextSongButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]"));
        playNextSongButton.click();
        playButton.click();
    }

    public boolean songIsPlaying(){
        WebElement playbar = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]"));
        return playbar.isDisplayed();
    }




}
