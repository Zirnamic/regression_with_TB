package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.When;

import static com.trycloud.utilities.BrowserUtils.waitForVisibility;

public class US_8_Step_Defs {

    FilesPage filesPage = new FilesPage();

    String searchFile = "";
    @When("the user clicks action-icon  from any file on the page to delete")
    public void the_user_clicks_action_icon_from_any_file_on_the_page_to_delete() {
        waitForVisibility(filesPage.recommendedFiles, 10);
        searchFile = filesPage.clickActionGetFileURL();
        System.out.println("\"" + searchFile + "\" file is moved to \"Deleted\"");
    }


}