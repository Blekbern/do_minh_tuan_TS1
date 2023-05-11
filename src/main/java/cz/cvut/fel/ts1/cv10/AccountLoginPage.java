package cz.cvut.fel.ts1.cv10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountLoginPage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = "button[title='Continue']" )
    private WebElement continueButton;

    public AccountLoginPage( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(continueButton) );
    }

    public RegistrationPage clickContinue() {
        continueButton.click();
        return new RegistrationPage( driver );
    }
}
