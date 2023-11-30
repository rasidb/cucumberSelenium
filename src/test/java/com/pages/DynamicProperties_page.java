package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicProperties_page {
    public DynamicProperties_page() {
        Driver.getDriver().get("https://demoqa.com/");
        WebElement element = Driver.getDriver().findElement(By.xpath("//h5[.='Elements']"));
        BrowserUtils.scrollByJs(element);
        element.click();
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "enableAfter")
    public WebElement enableAfter;
    @FindBy(id = "colorChange")
    public WebElement colorChange;
    @FindBy(id = "visibleAfter")
    public WebElement visibleAfter;
}
