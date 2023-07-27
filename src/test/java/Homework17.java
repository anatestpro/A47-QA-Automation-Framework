import org.testng.Assert;
import org.testng.annotations.Test;


//PLEASE HELP ME TO SOLVE THE ISSUE
public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){

        String newSongAddedToPlaylist = "Added 1 song into";

        navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchForSong("Dark Days");
        clickViewAll();
        selectTheFirstSong();
        clickAddToButton();
        chooseZumbaPlaylist();
        getNotificationText();

        Assert.assertTrue(getNotificationText().contains(newSongAddedToPlaylist));

    }
}
