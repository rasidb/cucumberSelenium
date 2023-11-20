package com.pom;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFrames_pom {
    public NestedFrames_pom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Nested Frames']")
    public WebElement nestedFramesPage;


    @FindBy(id = "frame1")
    public WebElement parentFrame;

    @FindBy(xpath = "//body")
    public WebElement frameText;

    @FindBy(xpath = "//iframe[contains(@srcdoc, 'Child Iframe')]")
    public WebElement innerFrame;
}
