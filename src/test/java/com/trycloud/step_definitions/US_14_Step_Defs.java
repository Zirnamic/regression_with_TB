package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US_14_Step_Defs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        dashboardPage.searchMagnifierIcon.click();
    }

    String searchInput = "979.png";

    @When("users search any existing file,folder or user name")
    public void users_search_any_existing_file_folder_or_user_name() {
        dashboardPage.searchInputBox.sendKeys(searchInput);
    }

    @Then("verify the app displays the expected search result option")
    public void verify_the_app_displays_the_expected_search_result_option() {
        String actualSearchResult = "";
        for(WebElement eachSearchResult : dashboardPage.searchList){
            System.out.println(eachSearchResult.getText());
            if (eachSearchResult.getText().contains(searchInput)){
                actualSearchResult = searchInput;
            }
        }
        Assert.assertEquals(searchInput, actualSearchResult);
    }


}