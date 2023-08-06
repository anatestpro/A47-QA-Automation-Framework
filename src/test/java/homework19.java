import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class homework19 extends BaseTest {
    @Test

    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";

        launchBrowser("https://qa.koel.app/");
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        ClickDeletePlaylistButton();

        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));

    }
}
