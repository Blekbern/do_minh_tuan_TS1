package cv10;

import cz.cvut.fel.ts1.cv10.MainPage;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAutomationStoreTest {

    @Test
    public void registrationTest() {
        System.setProperty("webdriver.gecko.driver","/home/dominhtu/School/ts1/cviko/project/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        new MainPage( driver ).openEShop().clickLoginOrRegister().clickContinue()
                .typeFirstName( "Borec" )
                .typeLastName( "Spagetka" )
                .typeEmail( "idk@wtf.com" );
    }

}
