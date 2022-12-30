#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import ${package}.pages.AccountPage;
import ${package}.pages.HomePage;
import ${package}.pages.LoginPage;
import ${package}.properties.Environment;
import org.picocontainer.annotations.Inject;

public class LoginSteps {
    @Inject
    HomePage homePage;
    @Inject
    LoginPage loginPage;
    @Inject
    AccountPage accountPage;

    @Given("I am on the login page of the website")
    public void i_am_on_the_login_page_of_the_website() {
        homePage.navigateToSignIn();
    }

    @When("I login with a valid email and invalid password")
    public void i_login_with_a_valid_email_and_invalid_password() {
        loginPage.login("customer@practicesoftwaretesting.com", "welcome1");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login(Environment.getProperties().email(), Environment.getProperties().password());
    }

    @Then("I should be redirected to my account")
    public void i_should_be_redirected_to_my_account() {
        Assertions.assertThat(accountPage.getPageTitle()).isEqualTo("My Account");
    }

    @Then("I should see an error message indicating that the password is incorrect")
    public void i_should_see_an_error_message_indicating_that_the_password_is_incorrect() {
        Assertions.assertThat(loginPage.getErrorMessage()).isEqualTo("Invalid email or password");
    }

}