package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsActions_page {
    public ButtonsActions_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    public WebElement rightClick;
    @FindBy(xpath = "//button[.='Click Me']")
    public WebElement dynamicClick;
}
