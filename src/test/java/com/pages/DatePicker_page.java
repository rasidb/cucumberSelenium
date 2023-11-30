package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_page {
    public DatePicker_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Select select;
    @FindBy(xpath = "//span[.='Date Picker']")
    public WebElement datePickerPage;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement openDatePicker;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement selectMonth;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement selectYear;
    @FindBy(xpath = "//div[.='9']")
    public WebElement day;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[2]")
    public WebElement openDateAndTime;
    @FindBy(className = "react-datepicker__month-read-view--selected-month")
    public WebElement openMonths;
    @FindBy(xpath = "//div[.='May']")
    public WebElement mayElement;
    @FindBy(className = "react-datepicker__year-read-view--selected-year")
    public WebElement openYears;
    @FindBy(xpath = "(//div[@class='react-datepicker__year-option'])[12]")
    public WebElement yearSelectScroll;
    @FindBy(xpath = "//div[.='1999']")
    public WebElement targetYear;
    @FindBy(className = "react-datepicker__day react-datepicker__day--009 react-datepicker__day--weekend")
    public WebElement targetDay;
    @FindBy(className = "react-datepicker__time-list")
    public WebElement hoursList;
    @FindBy(xpath = "//li[.='00:15']")
    public WebElement targetHour;
}
