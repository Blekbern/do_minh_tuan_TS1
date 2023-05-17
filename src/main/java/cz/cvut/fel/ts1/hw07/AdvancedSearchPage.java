package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedSearchPage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = "#all-words" )
    private WebElement allWords;
    @FindBy( how = How.CSS, using = "#exact-phrase" )
    private WebElement exactPhrase;
    @FindBy( how = How.CSS, using = "#least-words" )
    private WebElement oneOfWords;
    @FindBy( how = How.CSS, using = "#without-words" )
    private WebElement withoutWords;
    @FindBy( how = How.CSS, using = "#title-is" )
    private WebElement titleContains;
    @FindBy( how = How.CSS, using = "#author-is" )
    private WebElement author;
    @FindBy( how = How.CSS, using = "#facet-start-year" )
    private WebElement startYear;
    @FindBy( how = How.CSS, using = "#facet-end-year" )
    private WebElement endYear;
    @FindBy( how = How.CSS, using = "#submit-advanced-search" )
    private WebElement submitBtn;



    public AdvancedSearchPage(WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(allWords) );
    }

    public AdvancedSearchPage typeAllWords( String allWords ) {
        this.allWords.sendKeys( allWords );
        return this;
    }

    public AdvancedSearchPage typeExactPhrase( String exactPhrase ) {
        this.exactPhrase.sendKeys( exactPhrase );
        return this;
    }

    public AdvancedSearchPage typeOneOfWords( String oneOfWords ) {
        this.oneOfWords.sendKeys( oneOfWords );
        return this;
    }

    public AdvancedSearchPage typeWithoutWords( String withoutWords ) {
        this.withoutWords.sendKeys( withoutWords );
        return this;
    }

    public AdvancedSearchPage typeTitleContains( String titleContains ) {
        this.titleContains.sendKeys( titleContains );
        return this;
    }

    public AdvancedSearchPage typeAuthor( String author ) {
        this.author.sendKeys( author );
        return this;
    }

    public AdvancedSearchPage typeStartYear( String startYear ) {
        this.startYear.sendKeys( startYear );
        return this;
    }

    public AdvancedSearchPage typeEndYear( String endYear ) {
        this.endYear.sendKeys( endYear );
        return this;
    }

    public SearchResult clickSubmitBtn() {
        submitBtn.click();
        return new SearchResult( driver );
    }

}
