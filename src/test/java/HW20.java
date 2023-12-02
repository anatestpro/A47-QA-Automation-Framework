import org.testng.Assert;
import org.testng.annotations.Test;

public class HW20 extends BasicTest1ExplicitWaits {
    @Test

    public void deletePlaylist(){

        String deletedPlaylistNotification = "Deleted playlist \"loo.\"";

        //launchBrowser();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitButton();
        choosePlaylist();
        clickDeletePlaylistButton();

        Assert.assertEquals(DeletedPlaylistMessage(), deletedPlaylistNotification);

    }
}
