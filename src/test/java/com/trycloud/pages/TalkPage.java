package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkPage extends BasePage{

    @FindBy(className = "app-navigation-search__input")
    public WebElement searchUserBox;

    @FindBy(xpath = "//ul[@class='app-navigation__list']//a")
    public List<WebElement> userList;

    @FindBy(className = "new-message-form__advancedinput")
    public WebElement messageInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitMessageBtn;

    @FindBy(css = "div.message__main__text>div")
    public  List<WebElement> listOfMessages;


}