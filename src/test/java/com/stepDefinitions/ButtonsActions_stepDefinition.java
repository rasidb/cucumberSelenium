package com.stepDefinitions;

import com.pages.ButtonsActions_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsActions_stepDefinition extends ButtonsActions_page {
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
        Assertions.assertTrue(doubleClickMessage.isDisplayed());
        Assertions.assertTrue(rightClickMessage.isDisplayed());
        Assertions.assertTrue(dynamicClickMessage.isDisplayed());
    }


}
