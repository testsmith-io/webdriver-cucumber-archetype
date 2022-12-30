#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "[data-test='nav-sign-in']")
    private WebElement signInLink;

    public HomePage(TestContext context) {
        super(context.driver);
    }

    public void navigateToSignIn() {
        signInLink.click();
    }
}
