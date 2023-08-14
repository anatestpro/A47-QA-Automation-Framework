package BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage{

    By firstSong = By.cssSelector("#songsWrapper > div > div > div.item-container > table > tr.song-item.selected > td.title");
    By playSong = By.cssSelector("li.playback");
    By soundBar =By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div");
    public AllSongsPage(WebDriver givenDriver){

        super(givenDriver);
    }
    //Play song function
    By clickFirstSong = By.cssSelector("#songsWrapper > div > div > div.item-container > table > tr.song-item.selected > td.title");
    public void contextClickFirstSong(){

        contextClick(firstSong);
    }
    public void choosePlayOption(){
        findElement(playSong).click();
    }
    public Boolean IsSongPlaying(){
        return findElement(soundBar).isDisplayed();
    }

}
