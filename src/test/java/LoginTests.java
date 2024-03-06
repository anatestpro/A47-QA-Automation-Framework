import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test
    public void LoginValidEmailPasswordTest() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        //email and password fields

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));



        emailField.click();
        emailField.clear();
        emailField.sendKeys("anastasia.dovhal@testpro.io");

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        submitButton.click();
        // Wait for the next page to load (you can use explicit wait here)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));

        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }
}