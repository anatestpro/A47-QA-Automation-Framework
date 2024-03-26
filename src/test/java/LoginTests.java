import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //for opening the url in Chrome  driver.get(url)
        String url = "https://qa.koel.app/";
        driver.get(url);

        //put the email field inside the webpage
        WebElement emailInput = driver.findElement(cssSelector("[type='email'"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("anastasia.dovhal@testpro.io");

        //writing the password

        //check if the user avatar is displaying
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        //check if the user avatar is displaying
        WebElement button = driver.findElement(By.cssSelector("button"));

        Assert.assertTrue(button.isDisplayed());

        driver.quit();
    }
}