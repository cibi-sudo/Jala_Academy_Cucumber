package step_definitions;

import browserfactory.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.CreateEmployeePage;

import java.util.List;
import java.util.Map;

public class CreateEmployeePageDefinitions {
    CreateEmployeePage createEmployeePage = PageFactory.initElements(Browser.getDriver(), CreateEmployeePage.class);

    @Then("the user name field should have a maximum length of {string} characters")
    public void the_user_name_field_should_have_a_maximum_length_of_characters(String firstNameLength) {
        Assert.assertEquals(firstNameLength, createEmployeePage.firstNameMaxLength());
    }

    @Then("the user name field should have a placeholder of {string}")
    public void the_user_name_field_should_have_a_placeholder_of(String firstNamePlaceHolder) {
        Assert.assertEquals(firstNamePlaceHolder, createEmployeePage.firstNamePlaceholder());
    }

    @Then("the last name field should have a maximum length of {string} characters")
    public void the_last_name_field_should_have_a_maximum_length_of_characters(String lastNameLength) {
        Assert.assertEquals(lastNameLength, createEmployeePage.lastNameMaxLength());
    }

    @Then("the last name field should have a placeholder of {string}")
    public void the_last_name_field_should_have_a_placeholder_of(String lastNamePlaceHolder) {
        Assert.assertEquals(lastNamePlaceHolder, createEmployeePage.lastNamePlaceholder());
    }

    @When("the user enters an invalid email address {string} in the email field")
    public void the_user_enters_an_invalid_email_address_in_the_email_field(String invalidEmail) {
        createEmployeePage.enterEmail(invalidEmail);
    }

    @Then("the mobile number field should have a maximum length of {string} characters")
    public void the_mobile_number_field_should_have_a_maximum_length_of_characters(String mobileNumberLength) {
        Assert.assertEquals(mobileNumberLength, createEmployeePage.mobileNumberMaxLength());
    }

    @Then("the mobile number field should have a placeholder of {string}")
    public void the_mobile_number_field_should_have_a_placeholder_of(String mobileNumberPlaceHolder) {
        Assert.assertEquals(mobileNumberPlaceHolder, createEmployeePage.mobileNumberPlaceholder());
    }

    @Then("the male radio button should be selected")
    public void the_male_radio_button_should_be_selected() {
        Assert.assertTrue(createEmployeePage.maleRadioSelected());
    }

    @Then("the female radio button should not be selected")
    public void the_female_radio_button_should_not_be_selected() {
        Assert.assertFalse(createEmployeePage.femaleRadioSelected());
    }

    @Then("the city field should be disabled")
    public void the_city_field_should_be_disabled() {
        Assert.assertFalse(createEmployeePage.cityDisabled());
    }

    @Then("the other city field should have a placeholder of {string}")
    public void the_other_city_field_should_have_a_placeholder_of(String otherCityPlaceHolder) {
        Assert.assertEquals(otherCityPlaceHolder, createEmployeePage.otherCityPlaceholder());
    }

    @When("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        createEmployeePage.saveButton();
    }

    @Then("the user should see an error message indicating that all fields are required")
    public void the_user_should_see_an_error_message_indicating_that_all_fields_are_required() {
        Assert.assertTrue(createEmployeePage.saveButtonWarning());
        Assert.assertTrue(createEmployeePage.firstNameWarning());
        Assert.assertTrue(createEmployeePage.lastNameWarning());
        Assert.assertTrue(createEmployeePage.emailWarning());
        Assert.assertTrue(createEmployeePage.mobileNumberWarning());
    }

    @When("the user enters valid credentials in all fields following details in the column")
    public void the_user_enters_valid_credentials_in_all_fields_following_details_in_the_column(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeData = dataTable.asMaps(String.class, String.class);
        String firstName = employeeData.get(0).get("firstName");
        String lastName = employeeData.get(0).get("lastName");
        String email = employeeData.get(0).get("email");
        String mobileNumber = employeeData.get(0).get("mobileNumber");
        String dob = employeeData.get(0).get("dob");
        String address = employeeData.get(0).get("address");
        String country = employeeData.get(0).get("country");
        String city = employeeData.get(0).get("city");

        createEmployeePage.saveWithValidCredentials(firstName, lastName, email, mobileNumber, dob, address, country, city);

    }

    @When("the user clicks the skill checkbox")
    public void the_user_clicks_the_skill_checkbox() {
        createEmployeePage.clickSkills();
    }

    @Then("the user should be created successfully")
    public void the_user_should_be_created_successfully() {
        Assert.assertTrue(createEmployeePage.saveButtonWarning());
    }


    @When("the user enters an invalid mobile number in the mobile number field")
    public void the_user_enters_an_invalid_mobile_number_in_the_mobile_number_field() {
        Assert.assertTrue(createEmployeePage.mobileNumberWarning());
    }

    @When("the user selects the female radio button")
    public void the_user_selects_the_female_radio_button() {
        createEmployeePage.clickFemaleRadio();
    }

    @Then("the male radio button should not be selected")
    public void the_male_radio_button_should_not_be_selected() {
        Assert.assertFalse(createEmployeePage.maleRadioSelected());
    }

    @When("the user selects the male radio button")
    public void the_user_selects_the_male_radio_button() {
        createEmployeePage.clickMaleRadio();
    }

    @Then("the skills field should be spelled correctly as {string}")
    public void the_skills_field_should_be_spelled_correctly_as(String skillsSpelling) {
        Assert.assertEquals(skillsSpelling, createEmployeePage.checkSpellSkills());
    }

    @When("the user enters an invalid mobile number {string} in the mobile number field")
    public void the_user_enters_an_invalid_mobile_number_in_the_mobile_number_field(String inValidMobileNumber) {
        createEmployeePage.enterInValidMobileNumber(inValidMobileNumber);
    }

    @Then("the user should see an error message indicating that {string}")
    public void the_user_should_see_an_error_message_indicating_that(String inValidMobileNumberErrorMessage) {
        Assert.assertEquals(inValidMobileNumberErrorMessage, createEmployeePage.inValidMobileNumberWarning());
    }

    @Then("the user should see an error message indicating that the {string}")
    public void the_user_should_see_an_error_message_indicating_that_the(String inValidEmail) {
        Assert.assertEquals(inValidEmail, createEmployeePage.inValidEmailWarning());
    }
}
