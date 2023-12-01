package com.junitTests.topics;

import com.utilities.Driver;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class DropdownTests {

    @DisplayName("Handle all dropdowns on the page")
    @Test
    void dropdownTest() {
        // Navigate to the practice website
        Driver.getDriver().get("https://practice.cydeo.com/");

        // Click on the "Dropdown" link
        Driver.getDriver().findElement(By.linkText("Dropdown")).click();

        // Handle the first dropdown with id "dropdown"
        WebElement dropdown = Driver.getDriver().findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        Assertions.assertEquals("Option 1", select.getFirstSelectedOption().getText());

        // Handle the year dropdown
        WebElement year = Driver.getDriver().findElement(By.id("year"));
        select = new Select(year);
        select.selectByVisibleText("1999");
        Assertions.assertEquals("1999", select.getFirstSelectedOption().getText());

        // Handle the month dropdown
        WebElement month = Driver.getDriver().findElement(By.id("month"));
        select = new Select(month);
        select.selectByVisibleText("May");
        Assertions.assertEquals("May", select.getFirstSelectedOption().getText());

        // Handle the day dropdown
        WebElement day = Driver.getDriver().findElement(By.id("day"));
        select = new Select(day);
        select.selectByVisibleText("9");
        Assertions.assertEquals("9", select.getFirstSelectedOption().getText());

        // Handle the state dropdown
        WebElement state = Driver.getDriver().findElement(By.id("state"));
        select = new Select(state);
        select.selectByVisibleText("Arkansas");
        Assertions.assertEquals("Arkansas", select.getFirstSelectedOption().getText());
    }

}
