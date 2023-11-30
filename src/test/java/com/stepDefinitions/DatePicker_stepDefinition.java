package com.stepDefinitions;

import com.pages.DatePicker_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DatePicker_stepDefinition extends DatePicker_page {
    @Given("user open date picker menu")
    public void user_open_date_picker_menu() {
        BrowserUtils.setupDemoqaMenu("Widgets");
        datePickerPage.click();
    }

    @And("select a date")
    public void selectADate() {
        openDatePicker.click();
        select = new Select(selectMonth);
        select.selectByVisibleText("May");
        select = new Select(selectYear);
        select.selectByVisibleText("1999");
        BrowserUtils.scrollByJs(day);
        day.click();
    }

    @And("select date and time")
    public void selectDateAndTime() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(openDateAndTime).perform();
        openDateAndTime.click();
        openMonths.click();
        mayElement.click();
        openYears.click();
        while (true) {
            List<WebElement> years = Driver.getDriver().findElements(By.xpath("//div[@class='react-datepicker__year-option']"));
            BrowserUtils.scrollByJs(years.get(years.size() - 1));
            actions.moveToElement(years.get(years.size() - 1)).click().perform();
            try {
                if (targetYear.isDisplayed()) {
                    targetYear.click();
                    break;
                }
            } catch (NoSuchElementException e) {

            }
        }
        actions.moveToElement(targetDay).perform();
        targetDay.click();
        actions.moveToElement(hoursList).perform();
        BrowserUtils.scrollByJs(targetHour);
        targetHour.click();
    }


    @Then("assert results")
    public void assertResults() {
    }
}
