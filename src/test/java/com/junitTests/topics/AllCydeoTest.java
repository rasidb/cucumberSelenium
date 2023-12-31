package com.junitTests.topics;

import com.utilities.BrowserUtils;
import com.utilities.Driver;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllCydeoTest {
    @Before
    public void init() {
        Driver.getDriver().get("https://practice.cydeo.com/");
    }


    @Test
    public void addAndDeleteElements() {
        Driver.getDriver().findElement(By.linkText("Add/Remove Elements")).click();
        WebElement addBtn = Driver.getDriver().findElement(By.xpath("//button[.='Add Element']"));
        By deleteBy = By.xpath("//button[.='Delete']");
        List<WebElement> deleteButtons = Driver.getDriver().findElements(deleteBy);
        Assert.assertEquals(0, deleteButtons.size());
        addBtn.click();
        addBtn.click();
        addBtn.click();
        deleteButtons = Driver.getDriver().findElements(deleteBy);
        Assert.assertEquals(3, deleteButtons.size());
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }


    @Test
    public void autoComplete() {
        Driver.getDriver().findElement(By.linkText("Autocomplete")).click();
        WebElement submitSearchBox = Driver.getDriver().findElement(By.id("myCountry"));
        submitSearchBox.sendKeys("T");
        List<WebElement> countries = Driver.getDriver().findElements(By.xpath("//div[@id='myCountryautocomplete-list']//div//input"));
        for (WebElement country : countries) {
            System.out.println(country.getAttribute("value"));
            if (country.getAttribute("value").equals("Turkey")) {
                BrowserUtils.scrollDown(Driver.getDriver(), 300);
                try {
                    country.click();
                } catch (Exception e) {
                    BrowserUtils.clickElementJS(country);
                }
                break;
            }
        }
        Driver.getDriver().findElement(By.xpath("//input[@value='Submit']")).click();
        String result = Driver.getDriver().findElement(By.id("result")).getText();
        Assert.assertEquals("You selected: Turkey", result);

    }

}
