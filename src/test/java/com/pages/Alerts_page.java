package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alerts_page {

    public Alerts_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    public WebElement alertsPage;


    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResult;

    @FindBy(id = "promtButton")
    public WebElement promtButton;
    @FindBy(id = "promptResult")
    public WebElement promptResult;

}
