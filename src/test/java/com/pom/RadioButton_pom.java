package com.pom;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton_pom {
    public RadioButton_pom() {
        Driver.getDriver().get("https://demoqa.com/");
        WebElement element = Driver.getDriver().findElement(By.xpath("//h5[.='Elements']"));
        BrowserUtils.scrollByJs(element);
        element.click();
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "yesRadio")
    public WebElement radioBtnYes;
    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadio;
    @FindBy(id = "noRadio")
    public WebElement noRadio;
    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement radioText;
}
