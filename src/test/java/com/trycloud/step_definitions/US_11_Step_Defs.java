package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.TalkPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import static com.trycloud.utilities.BrowserUtils.*;

public class US_11_Step_Defs {

    TalkPage talkPage = new TalkPage();

    Faker faker = new Faker();

    String dummyMessage = faker.backToTheFuture().quote();

    @When("user search {string} from the search box")
    public void user_search_from_the_search_box(String searchUsername) {
        talkPage.searchUserBox.sendKeys(searchUsername);
        for(WebElement eachUser : talkPage.userList){
            if(eachUser.getAttribute("aria-label").endsWith(searchUsername)){
                eachUser.click();
            }
        }
    }
    @When("user write a message")
    public void user_write_a_message() {
        talkPage.messageInputBox.sendKeys(dummyMessage);
    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        waitFor(2); // again... Synchronization is killing me.
        talkPage.submitMessageBtn.click();
    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {
        String actualMessage = talkPage.listOfMessages.get(talkPage.listOfMessages.size()-1).getText();
        Assert.assertEquals(dummyMessage,actualMessage);
        Assert.assertTrue(talkPage.listOfMessages.get(talkPage.listOfMessages.size()-1).isDisplayed());
    }
}
