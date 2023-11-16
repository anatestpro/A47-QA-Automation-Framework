import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedToPlaylist = "Added 1 song into \"student.\"";

        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmitButton();
        openSearchField();
        clickViewAllButton();
        clickTheFirstSong();
        clickAddTo();
        selectPlaylist();

        Assert.assertEquals(getNotificationText(), newSongAddedToPlaylist);
    }


}
