package com.pom;

import com.utilities.BrowserUtils;
import com.utilities.Driver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoqaElements_pom {
    public Actions actions = new Actions(Driver.getDriver());
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @FindBy(xpath = "//span[.='Check Box']")
    public WebElement checkBoxBtn;









}
