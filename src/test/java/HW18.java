import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HW18 extends BasicTest {

    @Test

    public void playSong() throws InterruptedException {
        //navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitButton();

        clickPlayNextSong();
        clickPlayButton();
    }
        public boolean songIsPlaying() {
            WebElement soundBar = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]"));
            return soundBar.isDisplayed();
        }

    }

