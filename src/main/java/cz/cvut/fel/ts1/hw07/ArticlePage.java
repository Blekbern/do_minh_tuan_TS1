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

public class ArticlePage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = ".c-article-title" )
    private WebElement articleTitle;
    // wtf is this long ass css selector xdd
    @FindBy( how = How.CSS, using = ".c-bibliographic-information__list" )
    private WebElement aboutArticleInfo;
    private WebElement datePublished;
    @FindBy( how = How.CSS, using = "li[class='c-bibliographic-information__list-item c-bibliographic-information__list-item--doi'] span[class='c-bibliographic-information__value']" )
    private WebElement doi;

    public ArticlePage( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(articleTitle) );
    }

    public String getTitle() {
        return articleTitle.getText();
    }

    public String getDatePublished() {
        List<WebElement> articleInfoList = aboutArticleInfo.findElements( By.cssSelector( "li p" ) );
        String datePublished;
        for( WebElement info : articleInfoList ) {
            datePublished = info.getText();
            if( datePublished.contains( "Published" ) ) {
                String[] stringParts = datePublished.split( "\n" );
                return stringParts[1];
            }
        }
        return null;
    }

    public String getDoi() {
        return doi.getText();
    }
}
