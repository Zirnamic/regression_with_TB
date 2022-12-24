package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FavouritesPage;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.waitForInvisibilityOf;
import static com.trycloud.utilities.BrowserUtils.waitForVisibility;

public class US_6_Step_Defs {

    FilesPage filesPage = new FilesPage();
    FavouritesPage favouritesPage = new FavouritesPage();

    Faker faker = new Faker();

    String searchFile = "";

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {
        waitForVisibility(filesPage.recommendedFiles, 10);
        searchFile = filesPage.clickActionGetFileURLstarredFile();
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        String actualHREF = "";
        for(WebElement eachFile : favouritesPage.listOfFiles){
            if(eachFile.getAttribute("href").equals(searchFile)){
                actualHREF = eachFile.getAttribute("href");
            }else{
                actualHREF = faker.howIMetYourMother().quote();
            }
        }

        System.out.println("Actual href: " + actualHREF);
        Assert.assertNotEquals(searchFile, actualHREF);
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();
    }

    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_option(String option) {
        filesPage.chooseAddOption(option);
        filesPage.uploadFile("823.png");
    }

    @Then("verify {string} is displayed on the page")
    public void verify_is_displayed_on_the_page(String uploadedFileName) {
        filesPage.verifyFileIsDisplayed(uploadedFileName);
    }


}