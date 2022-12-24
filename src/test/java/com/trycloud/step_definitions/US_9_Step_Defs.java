package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.*;

public class US_9_Step_Defs {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    String searchFile = "";
    String commentMessage = faker.rickAndMorty().quote();

    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        waitForVisibility(filesPage.recommendedFiles, 10);
        searchFile = filesPage.clickActionGetFileOrFolderURL();
    }


    @When("user clicks on Comments section module")
    public void user_clicks_on_comments_section_module() {
        filesPage.commentsSectionModule.click();
    }


    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        filesPage.commentInputBar.sendKeys(commentMessage);
    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filesPage.submitCommentBtn.click();
        waitForClickability(filesPage.commentInputBar, 10);
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        String actualMessage = "";
        for(WebElement eachComment : filesPage.comments){
            System.out.println(eachComment.getText());
            if(eachComment.getText().equals(commentMessage)){
                actualMessage = eachComment.getText();
            }
        }
        Assert.assertEquals(commentMessage, actualMessage);
    }


}