package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;


public class US_3_Step_Defs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();



    @When("the users  log in with valid credentials {string}")
    public void the_users_log_in_with_valid_credentials(String username) {
        loginPage.login(username);
    }

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> modules) {
        for(int i = 0; i < dashboardPage.modules.size()-1; i++){
            Assert.assertTrue(dashboardPage.modules.get(i).isDisplayed());
            Assert.assertEquals(modules.get(i), dashboardPage.modules.get(i).getAttribute("aria-label"));
            //   System.out.println(dashboardPage.modules.get(i).getAttribute("aria-label"));
        }
    }
}