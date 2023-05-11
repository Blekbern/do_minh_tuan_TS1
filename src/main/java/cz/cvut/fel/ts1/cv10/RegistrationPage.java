package cz.cvut.fel.ts1.cv10;

//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy( how = How.CSS, using = "#AccountFrm_firstname" )
    private WebElement firstNameInput;
    @FindBy( how = How.CSS, using = "#AccountFrm_lastname" )
    private WebElement lastNameInput;
    @FindBy( how = How.CSS, using = "#AccountFrm_email" )
    private WebElement emailInput;
    @FindBy( how = How.CSS, using = ".maintext" )
    private WebElement pageTitle;



    public RegistrationPage( WebDriver driver ) {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
        PageFactory.initElements( driver, this );
        this.driver = driver;
        wait.until( ExpectedConditions.visibilityOf(firstNameInput) );
    }

    public RegistrationPage typeFirstName( String firstName ) {
        firstNameInput.sendKeys( firstName );
        return this;
    }

    public RegistrationPage typeLastName( String lastName ) {
        lastNameInput.sendKeys( lastName );
        return this;
    }

    public RegistrationPage typeEmail( String email ) {
        emailInput.sendKeys( email );
        return this;
    }

    public RegistrationPage titleHasText( String titleText ) {
//        pro Assertions smazat v pom.xml <scope>test</scope>
//        Assertions.assertEquals( titleText, pageTitle.getText() );
        return this;
    }

}
