package hw07Test;

import cz.cvut.fel.ts1.hw07.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkSpringerTest {

    FirefoxDriver driver;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.gecko.driver","/home/dominhtu/School/ts1/cviko/project/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void showLoginPage() {
        new MainPage( driver ).showMainPage()
                .getLoginScreen();
    }

    @Test
    public void showAdvancedSearch() {
        new MainPage( driver ).showMainPage()
                .openGearBtn()
                .selectAdvancedSearch();
    }

    @Test
    public void tryLogin() {
        new MainPage( driver ).showMainPage()
                .getLoginScreen()
                .typeEmailField( "wtf@idk.com" )
                .typePasswordField( "admin123" )
                .clickLogin();
    }
}
