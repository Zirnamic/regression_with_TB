package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US_1_Step_Defs {

    // pages:

    LoginPage loginPage = new LoginPage();



    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
    }
    @When("user use username {string} and passcode")
    public void user_use_username_and_passcode(String username) {
        loginPage.inputUserBox.sendKeys(username);
        loginPage.inputPasswordBox.sendKeys(ConfigReader.getProperty("password"));
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.submitButton.click();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }
}
