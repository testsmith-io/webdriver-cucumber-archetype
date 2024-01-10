#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.TestContext;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailInput = By.cssSelector("[data-test='email']");

    private final By passwordInput = By.cssSelector("[data-test='password']");

    private final By loginButton = By.cssSelector("[data-test='login-submit']");

    private final By errorMessage = By.cssSelector("[data-test='login-error']");

    public LoginPage(TestContext context) {
        super(context.driver);
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
