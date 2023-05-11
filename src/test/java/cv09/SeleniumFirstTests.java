package cv09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFirstTests {





    @Test
    public void firstTest() {
        System.setProperty("webdriver.gecko.driver","/home/dominhtu/School/ts1/cviko/project/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();

        driver.get( "https://automationteststore.com/index.php?rt=account/create" );

        String titleText = driver.findElement(By.cssSelector("h1 span.maintext")).getText();
        System.out.println( titleText );

        driver.findElement(By.cssSelector("#AccountFrm_firstname")).sendKeys( "Borec" );
        Select countrySelect = new Select( driver.findElement(By.cssSelector("#AccountFrm_country_id")) );
        countrySelect.selectByVisibleText( "Czech Republic" );

        driver.findElement( By.cssSelector("button[title='Continue']") ).click();
//        driver.quit();
    }

    @Test
    public void secondTest() {
        System.setProperty("webdriver.gecko.driver","/home/dominhtu/School/ts1/cviko/project/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();

        driver.get( "https://automationteststore.com/index.php?rt=account/create" );

        driver.findElement( By.cssSelector("#AccountFrm_firstname") ) . sendKeys( "Borec" );
        driver.findElement( By.cssSelector("#AccountFrm_lastname") ) . sendKeys( "Spagetka" );
        driver.findElement( By.cssSelector("#AccountFrm_email") ) . sendKeys( "idk@wtf.com" );
        driver.findElement( By.cssSelector("#AccountFrm_address_1") ) . sendKeys( "Hahahihi 9" );
        driver.findElement( By.cssSelector("#AccountFrm_city") ) . sendKeys( "Prague" );
        Select countrySelect = new Select( driver.findElement(By.cssSelector("#AccountFrm_country_id")) );
        countrySelect.selectByVisibleText( "Czech Republic" );
        Select regionSelect = new Select( driver.findElement(By.cssSelector("#AccountFrm_zone_id")) );
        regionSelect.selectByVisibleText( "Praha" );
        driver.findElement( By.cssSelector("#AccountFrm_loginname") ) . sendKeys( "gugugaga" );
        driver.findElement( By.cssSelector("#AccountFrm_postcode") ) . sendKeys( "10000" );
        driver.findElement( By.cssSelector("#AccountFrm_password") ) . sendKeys( "admin123" );
        driver.findElement( By.cssSelector("#AccountFrm_confirm") ) . sendKeys( "admin123" );
        driver.findElement( By.cssSelector("#AccountFrm_newsletter0")).click();
        driver.findElement( By.cssSelector("#AccountFrm_agree")).click();
        driver.findElement( By.cssSelector("button[title='Continue']") ).click();
    }
}
