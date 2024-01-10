#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.TestContext;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By signInLink = By.cssSelector("[data-test='nav-sign-in']");

    public HomePage(TestContext context) {
        super(context.driver);
    }

    public void navigateToSignIn() {
        driver.findElement(signInLink).click();
    }
}
