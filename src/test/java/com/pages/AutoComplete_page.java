package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoComplete_page {
    public AutoComplete_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @FindBy(xpath = "//span[.='Auto Complete']")
    public WebElement autoCompletePage;
    @FindBy(id = "autoCompleteMultipleInput")
    public WebElement autoCompleteMultipleInput;
    @FindBy(xpath = "//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']//div")
    public WebElement multipleFirstSelect;
    @FindBy(xpath = "//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
    public WebElement firstMultiCheckText;
    @FindBy(xpath = "(//div[@class='css-12jo7m5 auto-complete__multi-value__label'])[2]")
    public WebElement secMultiCheckText;

    @FindBy(id = "autoCompleteSingleInput")
    public WebElement autoCompleteSingleInput;
    @FindBy(xpath = "//div[@class='auto-complete__menu-list css-11unzgr']//div")
    public WebElement singleSelectFirst;
    @FindBy(xpath = "//div[@class='auto-complete__value-container auto-complete__value-container--has-value css-1hwfws3']//div")
    public WebElement singleTextCheck;
}
