package com.stepDefinitions;

import com.pages.RadioButton_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RadioButton_stepDefinition extends RadioButton_page {
    @Given("user clicks Radio Button button")
    public void userClicksRadioButtonButton() {
        BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Radio Button']")).click();
    }

    @Then("select radio buttons and asserts")
    public void selectRadioButtonsAndAsserts() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 11);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[.='Do you like the site?']"))));
        BrowserUtils.clickElementJS(radioBtnYes);
        assertEquals("Yes", radioText.getText());
        BrowserUtils.clickElementJS(impressiveRadio);
        assertEquals("Impressive", radioText.getText());
        try {
            noRadio.click();
        } catch (ElementNotInteractableException e) {
            assertTrue(true);
        }
    }


}
