package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FavouritesPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.*;


public class US_5_Step_Defs {

    // tools:
    Faker faker = new Faker();



    // page objects:
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    FilesPage filesPage = new FilesPage();
    FavouritesPage favouritesPage = new FavouritesPage();



    // dummies
    String searchFile = "";



    @Given("{string} on the dashboard page")
    public void on_the_dashboard_page(String user) {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        loginPage.login(user);
        System.out.println("Logged in with the username: " + user);
    }


    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {
        dashboardPage.clickModule(module);
    }


    @When("the user clicks action-icon  from any file on the page to add to favourites")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        waitForVisibility(filesPage.recommendedFiles, 10);
        searchFile = filesPage.clickActionGetFileURLnostarFile();
    }


    @When("user choose the {string} option")
    public void user_choose_the_option(String option) {
        filesPage.chooseActionOption(option);
    }


    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String submodule) {
        filesPage.clickSubModule(submodule);
        waitForClickability(favouritesPage.sortByNameBtn, 10);
    }


    @Then("Verify the chosen file is listed on the table")
    public void verify_the_is_listed_on_the_table() {
        String actualHREF = faker.howIMetYourMother().quote();
        for(WebElement eachFile : favouritesPage.listOfFiles){
            if(eachFile.getAttribute("href").equals(searchFile)){
                actualHREF = eachFile.getAttribute("href");
            }
        }

        Assert.assertEquals(searchFile, actualHREF);

    }


}