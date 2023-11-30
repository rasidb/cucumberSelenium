package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames_page {
    public Frames_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Frames']")
    public WebElement framesPage;
    @FindBy(id = "frame1")
    public WebElement innerFrame;
    @FindBy(id = "sampleHeading")
    public WebElement textFromInnerFrame;
}
