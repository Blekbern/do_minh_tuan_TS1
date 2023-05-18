package hw07Test;

import cz.cvut.fel.ts1.hw07.ArticleInfo;
import cz.cvut.fel.ts1.hw07.ArticlePage;
import cz.cvut.fel.ts1.hw07.MainPage;
import cz.cvut.fel.ts1.hw07.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class LinkSpringerTest {

    FirefoxDriver driver;
    ArrayList<ArticleInfo> articleInfoList = new ArrayList<ArticleInfo>();

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
    public void testAdvancedSearch3() {
        new MainPage( driver ).showMainPage().getThisShitOffTheScreen()
                .openGearBtn()
                .selectAdvancedSearch()
                .typeAllWords( "Lakers in 5" )
                .typeAuthor( "Sharpe" )
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

    @Test
    public void bigTest() {
        SearchResult searchRes =
            new MainPage(driver).showMainPage().getThisShitOffTheScreen()
                    .openGearBtn()
                    .selectAdvancedSearch()
                    .typeAllWords("Page Object Model")
                    .typeOneOfWords("Sellenium Testing")
                    .typeStartYear("2023")
                    .typeEndYear("2023")
                    .clickSubmitBtn()
                    .getArticleSearchRes();
        
        for( int i = 0; i < 4; i++ ) {
            ArticlePage articlePage = searchRes.clickArticlePage( i );
            ArticleInfo articleInfo = new ArticleInfo(
                    articlePage.getTitle(),
                    articlePage.getDoi(),
                    articlePage.getDatePublished()
            );
            System.out.println( articleInfo.getTitle() );
            System.out.println( articleInfo.getDoi() );
            System.out.println( articleInfo.getDatePublished() );
            articleInfoList.add( articleInfo );
            driver.navigate().back();
        }
    }
}
