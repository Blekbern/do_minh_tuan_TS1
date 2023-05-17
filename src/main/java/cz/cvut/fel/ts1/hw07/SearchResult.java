package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResult {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = "#content-type-facet" )
    private WebElement contentTypes;
    private WebElement articleSelect;
    @FindBy( how = How.CSS, using = "#results-list")
    private WebElement searchResultList;

    public SearchResult( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(contentTypes) );
    }

    public SearchResult getArticleSearchRes() {
        List<WebElement> listItems = contentTypes.findElements( By.cssSelector("ol li a") );
        for( WebElement listItem : listItems ) {
            // could put String contentType parameter and just pass Article as an argument in Test but im lazy xdd
            if( listItem.findElement(By.cssSelector("span.facet-title")).getText().equals("Article") ) {
                articleSelect = listItem;
                break;
            }
        }
        articleSelect.click();
        return this;
    }

    public ArticlePage clickArticlePage( int listItemIndex ) {
        List<WebElement> listItems = searchResultList.findElements( By.cssSelector( "li h2 a" ) );
        listItems.get( listItemIndex ).click();
        return new ArticlePage( driver );
    }
}
