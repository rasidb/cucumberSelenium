package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox_page {
    public TextBox_page() {
        Driver.getDriver().get("https://demoqa.com/");
        WebElement element = Driver.getDriver().findElement(By.xpath("//h5[.='Elements']"));
        BrowserUtils.scrollByJs(element);
        element.click();
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public String username = "deniz";
    public String email = "deniz@gmail.com";
    public String adress = "Sivas";

    @FindBy(id = "userName")
    public WebElement usernameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressElement;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressElement;
    @FindBy(id = "submit")
    public WebElement submitBtnElement;
    @FindBy(id = "name")
    public WebElement assertNameElement;
    @FindBy(id = "email")
    public WebElement assertEmailElement;

}
