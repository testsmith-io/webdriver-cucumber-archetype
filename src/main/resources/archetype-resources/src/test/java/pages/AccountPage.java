#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.TestContext;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private final By pageTitle = By.cssSelector("h1[data-test='page-title']");

    public AccountPage(TestContext context) {
        super(context.driver);
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
