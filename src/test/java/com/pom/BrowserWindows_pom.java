package com.pom;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindows_pom {
    public BrowserWindows_pom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Browser Windows']")
    public WebElement browserWindowsPage;
    @FindBy(id = "tabButton")
    public WebElement tabButton;
    @FindBy(id = "sampleHeading")
    public WebElement tabWindowText;
    @FindBy(id = "windowButton")
    public WebElement newWindow;
    @FindBy(id = "sampleHeading")
    public WebElement NewWindowText;
}
