package step_definitions;

import browserfactory.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.CreateEmployeePage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageStepDefinitions {
    LoginPage loginPage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
    HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);
    CreateEmployeePage createEmployeePage = PageFactory.initElements(Browser.getDriver(), CreateEmployeePage.class);

    @Given("User is able to login with valid email {string} and valid password {string}")
    public void user_is_able_to_login_with_valid_email_and_valid_password(String validUsername, String validPassword) {
        loginPage.loginToApplication(validUsername, validPassword);
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        homePage.clickLogout();
    }

    @Then("the user is logged out and should be able to see Sign-in")
    public void the_user_is_logged_out_and_should_be_able_to_see_sign_in() {
        Assert.assertTrue(loginPage.visibleSignIn());
    }

    @When("the user clicks the employee")
    public void the_user_clicks_the_employee() {
        homePage.clickEmployee();
    }

    @Then("the user is able to see create")
    public void the_user_is_able_to_see_create() {
        Assert.assertTrue(homePage.visible_Create());
    }

    @Then("the user is able to see search")
    public void the_user_is_able_to_see_search() {
        Assert.assertTrue(homePage.visible_Search());
    }

    @Then("the user is clicks the create")
    public void the_user_is_clicks_the_create() {
        homePage.clickCreateOnEmployee();
    }

    @Then("the user is taken to the create employee page")
    public void the_user_is_taken_to_the_create_employee_page() {
        Assert.assertTrue(createEmployeePage.visibleEmployeeDetails());
    }
}
