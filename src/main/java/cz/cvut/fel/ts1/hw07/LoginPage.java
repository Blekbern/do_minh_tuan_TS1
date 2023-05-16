package cz.cvut.fel.ts1.hw07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    @FindBy( how = How.CSS, using = "#login-box-email" )
    private WebElement emailInput;
    @FindBy( how = How.CSS, using = "#login-box-pw" )
    private WebElement passwordInput;
    @FindBy( how = How.CSS, using = "button[title='Log in']" )
    private WebElement loginBtn;

    public LoginPage( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(emailInput) );
    }

    public LoginPage typeEmailField( String email ) {
        emailInput.sendKeys( email );
        return this;
    }

    public LoginPage typePasswordField( String pwd ) {
        passwordInput.sendKeys( pwd );
        return this;
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
