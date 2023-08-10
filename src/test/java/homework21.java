import org.testng.Assert;
import org.testng.annotations.Test;

public class homework21 extends BaseTest {
    @Test

    public void renamePlaylist() throws InterruptedException {

    provideEmail("anastasia.dovhal@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    doubleClickPlaylist();
    enterNewPlaylistName();
    Assert.assertTrue(playlistExists());


    }
}
