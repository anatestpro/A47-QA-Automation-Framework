import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW16 extends BasicTest {

    @Test (enabled = true)
    public void registrationNavigation(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        String registrationUrl ="https://qa.koel.app/registration";

        driver.get(url);

        WebElement registrationButton = driver.findElement(By.cssSelector("[href='registration']"));

        registrationButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }
}
