import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException{

        navigateToPage();
        provideEmail("anastasia.dovhal@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlayButton();
    }
}
