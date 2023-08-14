import BasePages.AllSongsPage;
import BasePages.BasePage;
import BasePages.HomePage;
import BasePages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaySongTest extends BaseTest {
    @Test

    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.provideEmail("anastasia.dovhal@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.chooseAllSongslist();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();

        Assert.assertTrue(allSongs.IsSongPlaying());

    }


}
