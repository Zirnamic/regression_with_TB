package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage{


    @FindBy(className = "app-content-list-item-line-one")
    public List<WebElement> contactsNameList;

    @FindBy(id = "new-contact-button")
    public WebElement addNewContactBtn;

    @FindBy(css = "input[inputmode='tel']")
    public WebElement inputNewPhone;

    @FindBy(css = "input[inputmode='email']")
    public WebElement inputNewEmail;

    @FindBy(css = "h2>input#contact-fullname")
    public WebElement contactNameProfile;


}