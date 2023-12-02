import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BasicTest {
    @Test

    public void deletePlaylist() throws InterruptedException{

        String deletedPlaylistNotification = "Deleted playlist \"loo.\"";
        //launchBrowser();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitButton();
        choosePlaylist();
        clickDeletePlaylistButton();

       Assert.assertEquals(getDeletedPlaylistMessage(), deletedPlaylistNotification);



    }
}
