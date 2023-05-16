package com.classicCRM.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	

@Given("I am on Classic CRM Page")
public void i_am_on_classic_crm_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_am_on_classic_crm_page");
}
@When("^I enter (.+) in username$")
public void i_enter_name2_in_username(String uname) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("enter uname "+uname);
}
@When("^I enter (.+) in password field$")
public void i_enter_passowrd_in_password_field(String password) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Enter password : "+password);
}
@When("click on login button")
public void click_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("click_on_login_button");
}
@Then("I should not redirect to any page")
public void i_should_not_redirect_to_any_page_verify_title_again() {
    // Write code here that turns the phrase above into concrete actions
System.out.println("i_should_not_redirect_to_any_page_verify_title_again");
}

//first test


@Given("I have verified its title")
public void i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support() {
    // Write code here that turns the phrase above into concrete actions
    //title should be - #Free CRM  - CRM software for customer relationship management, sales, and support.
	
	System.out.println("i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support");
}
@When("I enter valid Email ID")
public void i_enter_valid_email_id() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_enter_valid_email_id");
}
@When("valid password")
public void valid_password() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_enter_valid_pass_id");
}

@Then("I logged into crm")
public void i_logged_into_crm_crmpro_title() {
    // Write code here that turns the phrase above into concrete actions
   System.out.println("i_logged_into_crm_crmpro_title");
}
@Then("check for login user")
public void check_for_login_user_shruti_automation() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("check_for_login_user_shruti_automation");
}


}
