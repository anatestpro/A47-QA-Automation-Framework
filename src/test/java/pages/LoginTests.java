package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BasePage {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}

