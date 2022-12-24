package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.ContactsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.trycloud.utilities.BrowserUtils.waitFor;

public class US_13_Step_Defs {

    ContactsPage contactsPage = new ContactsPage();

    Faker faker = new Faker();

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        while(contactsPage.contactsNameList.size() < 2) {  // pre-condition
            String name = faker.funnyName().name();
            contactsPage.addNewContactBtn.click();
            contactsPage.inputNewPhone.sendKeys(faker.numerify("#######"));
            contactsPage.inputNewEmail.sendKeys(faker.internet().emailAddress(name));
            contactsPage.contactNameProfile.clear();
            contactsPage.contactNameProfile.sendKeys(name);
            waitFor(1); // lol, it's SO fast, if I do not stop here the last created contact will not save the name and his name will be New Contact in Assertion.

        }
        for (WebElement eachName : contactsPage.contactsNameList) {
            Assert.assertTrue(eachName.isDisplayed());
            System.out.println(eachName.getText());
        }
    }

}