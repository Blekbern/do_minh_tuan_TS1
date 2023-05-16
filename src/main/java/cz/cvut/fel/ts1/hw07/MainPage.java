package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = "div[class='cross-nav cross-nav--wide'] a[class='register-link flyout-caption']" )
    private WebElement LoginScreenAnchor;
    @FindBy( how = How.CSS, using = "#advanced-search-link" )
    private WebElement AdvancedSearchBtn;

    public MainPage(WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
//        wait.until( ExpectedConditions.visibilityOf(loginOrRegisterAnchor) );
        this.driver = driver;
    }

    public MainPage showMainPage() {
        driver.get( "https://link.springer.com/" );
        return this;
    }

    public LoginPage getLoginScreen() {
        LoginScreenAnchor.click();
        return new LoginPage( driver );
    }

    public AdvancedSearch getAdvancedSearch() {
        AdvancedSearchBtn.click();
        return new AdvancedSearch( driver );
    }
}
