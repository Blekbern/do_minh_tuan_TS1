package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedSearchPage {

    private WebDriver driver;


    public AdvancedSearchPage(WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
//        wait.until( ExpectedConditions.visibilityOf(AdvancedSearchSelect) );
    }
}
