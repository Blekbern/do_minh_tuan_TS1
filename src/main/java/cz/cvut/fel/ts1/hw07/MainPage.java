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
    private WebElement loginScreenAnchor;
    @FindBy( how = How.CSS, using = "img[alt='Search Options']" )
    private WebElement gearBtn;
    @FindBy( how = How.CSS, using = "#advanced-search-link" )
    private WebElement advancedSearchSelect;

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
        loginScreenAnchor.click();
        return new LoginPage( driver );
    }

    public MainPage openGearBtn() {
        gearBtn.click();
        return this;
    }

    public AdvancedSearchPage selectAdvancedSearch() {
        advancedSearchSelect.click();
        return new AdvancedSearchPage( driver );
    }
}
