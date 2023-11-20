package com.stepDefinitions;

import com.pom.ButtonsActions_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsActions_stepDefinition extends ButtonsActions_pom {
    @Given("user clicks Buttons button")
    public void userClicksButtonsButton() {
     BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Buttons']")).click();
    }
    @And("clicks all buttons on the page")
    public void clicksAllButtonsOnThePage() {
        Actions actions=new Actions(Driver.getDriver());
        BrowserUtils.scrollByJs(doubleClickBtn);
        actions.doubleClick(doubleClickBtn).perform();
        actions.moveToElement(rightClick).contextClick().perform();
        actions.click(dynamicClick).perform();
    }
    @Then("assert assertions")
    public void assertAssertions() {
        WebElement doubleClickMessage = Driver.getDriver().findElement(By.id("doubleClickMessage"));
        WebElement rightClickMessage = Driver.getDriver().findElement(By.id("rightClickMessage"));
        WebElement dynamicClickMessage = Driver.getDriver().findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        Assert.assertTrue(rightClickMessage.isDisplayed());
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
    }


}
