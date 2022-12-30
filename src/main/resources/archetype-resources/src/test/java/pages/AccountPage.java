#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = "h1[data-test='page-title']")
    private WebElement pageTitle;

    public AccountPage(TestContext context) {
        super(context.driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
