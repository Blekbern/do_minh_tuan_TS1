package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticlePage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = ".c-article-title" )
    private WebElement articleTitle;
    @FindBy( how = How.CSS, using = "#article-info time")
    private WebElement datePublished;

    public ArticlePage( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
//        wait.until( ExpectedConditions.visibilityOf(contentTypes) );
    }

    public String getTitle() {
        // todo
        return null;
    }

    public String getDatePublished() {
        // todo
        return null;
    }
}
