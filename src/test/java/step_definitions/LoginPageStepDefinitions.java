package step_definitions;


import browserfactory.Browser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;


public class LoginPageStepDefinitions {
    LoginPage loginPage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
    ForgetPasswordPage forgetPasswordPage = PageFactory.initElements(Browser.getDriver(), ForgetPasswordPage.class);
    HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);

    @Given("the user should be able to see login")
    public void the_user_should_be_able_to_see_login() {
        Assert.assertTrue(loginPage.visibleSignIn());
    }
    @When("the user enters their valid email {string} and valid password {string}")
    public void the_user_enters_their_valid_email_and_valid_password(String validEmail, String validPassword) {
        loginPage.loginToApplication(validEmail, validPassword);
    }

    @When("the user clicks the Remember")
    public void the_user_clicks_the_remember() {
        loginPage.clickRemember();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be able to see logout")
    public void the_user_should_be_able_to_see_logout() {
        Assert.assertTrue(homePage.logoutVisible());
    }

    @When("the user enters an invalid email {string} and invalid password {string}")
    public void the_user_enters_an_invalid_email_and_invalid_password(String invalidEmail, String invalidPassword) {
        loginPage.loginToApplication(invalidEmail, invalidPassword);
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        Assert.assertTrue(loginPage.warningMessage());
    }

    @When("the user enters an invalid email {string} and a valid password {string}")
    public void the_user_enters_an_invalid_email_and_a_valid_password(String invalidEmail, String validPassword) {
        loginPage.loginToApplication(invalidEmail, validPassword);
    }

    @Then("the user should see an invalidEmail error message")
    public void the_user_should_see_an_invalid_email_error_message() {
        Assert.assertTrue(loginPage.emailWarning());
    }

    @When("the user enters a valid email {string} and an invalid password {string}")
    public void the_user_enters_a_valid_email_and_an_invalid_password(String validEmail, String invalidPassword) {
        loginPage.loginToApplication(validEmail, invalidPassword);
    }

    @Then("the user should see an invalidPassword error message")
    public void the_user_should_see_an_invalid_password_error_message() {
        Assert.assertTrue(loginPage.passwordWarning());
    }

    @When("the user clicks the forget password link")
    public void the_user_clicks_the_forget_password_link() {
        loginPage.clickForgetPassword();
    }

    @Then("the user should be on the forget password page")
    public void the_user_should_be_on_the_forget_password_page() {
        Assert.assertTrue(forgetPasswordPage.visiblePasswordContainer());
    }

    @When("the user enters their valid email {string}")
    public void the_user_enters_their_valid_email(String validEmail) {
        loginPage.enterEmail(validEmail);
    }

    @When("the user presses the tab key")
    public void the_user_presses_the_tab_key() {
        loginPage.clickTab();
    }

    @When("the user enters their valid password {string}")
    public void the_user_enters_their_valid_password(String validPassword) {
        loginPage.enterPassword(validPassword);
    }

    @When("the user presses the enter key")
    public void the_user_presses_the_enter_key() {
        loginPage.clickEnter();
    }

    @Then("the username placeholder should be {string}")
    public void the_username_placeholder_should_be(String userNamePlaceHolder) {
        Assert.assertEquals(userNamePlaceHolder, loginPage.usernamePlaceholder());
    }

    @Then("the password placeholder should be {string}")
    public void the_password_placeholder_should_be(String passwordNamePlaceHolder) {
        Assert.assertEquals(passwordNamePlaceHolder, loginPage.passwordPlaceholder());
    }

    @When("the user not enters their email and password")
    public void the_user_not_enters_their_email_and_password() {
        loginPage.loginToApplication("", "");
    }

    @Then("the user should be able to see email warning")
    public void the_user_should_be_able_to_see_email_warning() {
        Assert.assertTrue(loginPage.visibleEmailWarning());
    }

    @Then("the user should be able to see password warning")
    public void the_user_should_be_able_to_see_password_warning() {
        Assert.assertTrue(loginPage.visiblePasswordWarning());
    }

}
