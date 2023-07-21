import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
    launchBrowser();
        navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

        @Test
    public void LoginInvalidEmailPassword () {
        navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("nopassword");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
        }

        @Test
    public void changeProfileName(){
        navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();


        clickAvatarIcon();

        String randomName = generateRandomName();

        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),randomName);
        }



}
