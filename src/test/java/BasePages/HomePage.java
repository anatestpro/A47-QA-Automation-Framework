package BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvater(){
        return findElement(userAvatarIcon);
    }

}
