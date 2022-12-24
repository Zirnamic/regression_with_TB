package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.*;

public class US_4_Step_Defs {

    FilesPage filesPage = new FilesPage();

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitleName) {
        verifyTitle(Driver.getDriver(), expectedTitleName);
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.checkBoxForAll.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        for(WebElement eachCheckBox : filesPage.checkBoxes){
            Assert.assertTrue(eachCheckBox.isSelected());
        }
    }

}