package hw07Test;

import cz.cvut.fel.ts1.hw07.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkSpringerTest {

    FirefoxDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.gecko.driver","/home/dominhtu/School/ts1/cviko/project/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void hideThisShit() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen();
    }

    @Test
    public void testShowLoginPage() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .getLoginScreen();
    }

    @Test
    public void testShowAdvancedSearch() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .openGearBtn()
                .selectAdvancedSearch();
    }

    @Test
    public void testLogin() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .getLoginScreen()
                .typeEmailField( "wtf@idk.com" )
                .typePasswordField( "admin123" )
                .clickLogin();
    }

    @Test
    public void testAdvancedSearch1() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .openGearBtn()
                .selectAdvancedSearch()
                .typeAllWords( "this" )
                .typeExactPhrase( "To be or not to be" )
                .typeOneOfWords( "finger" )
                .typeWithoutWords( "jacket" )
                .clickSubmitBtn();
    }

    @Test
    public void testAdvancedSearch2() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .openGearBtn()
                .selectAdvancedSearch()
                .typeAllWords( "human" )
                .typeExactPhrase( "existential crisis" )
                .typeOneOfWords( "kill" )
                .typeWithoutWords( "happiness" )
                .typeTitleContains( "war" )
                .typeStartYear( "0" )
                .typeEndYear( "2022" )
                .clickSubmitBtn();
    }

    @Test
    public void testGetSearchResult() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .getSearchResults( "Technological singularity" );
    }

    @Test
    public void testSearchArticles() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .getSearchResults( "Serial killers" )
                .getArticleSearchRes();
    }

}
