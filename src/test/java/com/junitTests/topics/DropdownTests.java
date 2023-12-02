package com.junitTests.topics;

import com.utilities.Driver;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



 public class DropdownTests {


    @Test
    public void dropdownTest() {
        // Navigate to the practice website
        Driver.getDriver().get("https://practice.cydeo.com/");

        // Click on the "Dropdown" link
        Driver.getDriver().findElement(By.linkText("Dropdown")).click();

        // Handle the first dropdown with id "dropdown"
        WebElement dropdown = Driver.getDriver().findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1", select.getFirstSelectedOption().getText());

        // Handle the year dropdown
        WebElement year = Driver.getDriver().findElement(By.id("year"));
        select = new Select(year);
        select.selectByVisibleText("1999");
        Assert.assertEquals("1999", select.getFirstSelectedOption().getText());

        // Handle the month dropdown
        WebElement month = Driver.getDriver().findElement(By.id("month"));
        select = new Select(month);
        select.selectByVisibleText("May");
        Assert.assertEquals("May", select.getFirstSelectedOption().getText());

        // Handle the day dropdown
        WebElement day = Driver.getDriver().findElement(By.id("day"));
        select = new Select(day);
        select.selectByVisibleText("9");
        Assert.assertEquals("9", select.getFirstSelectedOption().getText());

        // Handle the state dropdown
        WebElement state = Driver.getDriver().findElement(By.id("state"));
        select = new Select(state);
        select.selectByVisibleText("Arkansas");
        Assert.assertEquals("Arkansas", select.getFirstSelectedOption().getText());
    }

}
