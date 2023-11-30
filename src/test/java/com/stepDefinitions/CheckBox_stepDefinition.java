package com.stepDefinitions;

import com.pages.ChecBox_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class CheckBox_stepDefinition extends ChecBox_page {
    @Given("user clicks Check Box button")
    public void userClicksCheckBoxButton() {
        BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Check Box']")).click();
    }

    @And("select boxes")
    public void selectBoxes() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.elementToBeClickable(expandAllBtn)).click();
        if (!expandAllBtn.isSelected()){
            expandAllBtn.click();
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement notes = Driver.getDriver().findElement(By.xpath("//span[.='Notes']//label//span"));
        WebElement react = Driver.getDriver().findElement(By.xpath("//span[.='React']//label//span"));
        WebElement priv = Driver.getDriver().findElement(By.xpath("//span[.='Private']//label//span"));
        BrowserUtils.scrollByJs(notes);
        notes.click();
        BrowserUtils.scrollByJs(react);
        react.click();
        BrowserUtils.scrollByJs(priv);
        priv.click();
    }

    @Then("assert all informations")
    public void assertAllInformations() {
        WebElement result = Driver.getDriver().findElement(By.id("result"));
        assertEquals("You have selected :\n" +
                "notes\n" +
                "react\n" +
                "private", result.getText());
    }


}
