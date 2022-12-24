package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.trycloud.utilities.BrowserUtils.*;
import static com.trycloud.utilities.JavaUtils.*;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // --- MAIN (top of the page) MODULES:

    @FindBy(css = "ul#appmenu>li>a")
    public List<WebElement> modules;

    public void clickModule(String module){
        WebElement actualModule = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='" + normalizeCase(module) + "']/.."));
        waitForClickability(actualModule, 10);
        actualModule.click();
    }

    @FindBy(css = "span[aria-label='Magnify icon']")
    public WebElement searchMagnifierIcon;

    // search pop-up menu:

    @FindBy(css = "input.unified-search__form-input")
    public WebElement searchInputBox;

    @FindBy(css = "span.unified-search__result-content>h3")
    public List<WebElement> searchList;

}
