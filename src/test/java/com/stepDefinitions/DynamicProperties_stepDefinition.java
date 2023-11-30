package com.stepDefinitions;

import com.pages.DynamicProperties_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicProperties_stepDefinition extends DynamicProperties_page {
    @Given("user clicks Dynamic Properties button")
    public void userClicksDynamicPropertiesButton() {
        BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Dynamic Properties']")).click();
    }

    @And("wait elements for click")
    public void waitElementsForClick() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();
        BrowserUtils.scrollByJs(visibleAfter);
        wait.until(ExpectedConditions.visibilityOf(visibleAfter)).click();

    }

    @Then("the button color changes")
    public void theButtonColorChanges() {
        String color =colorChange.getCssValue("color");
        Assert.assertEquals("rgba(220, 53, 69, 1)",color);
    }

    @Given("user clicks {string} button")
    public void userClicksButton(String arg0) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+arg0+"']")).click();
    }


}
