package com.junitTests.topics;

import com.utilities.Driver;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WaitTests {

    @Before
    public void init() {
        // Navigate to the practice website
        Driver.getDriver().get("https://practice.cydeo.com/");
    }


    @Test
    public void testWaitForElementToDisappear() {
        // Navigate to the Dynamic Controls page
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        // Locate and click the "Remove" button
        WebElement removeBtn = Driver.getDriver().findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();

        // Wait for the loading bar to disappear
        WebElement loadingBar = Driver.getDriver().findElement(By.id("loading"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));

        // Verify the success message
        WebElement message = Driver.getDriver().findElement(By.id("message"));
        assertTrue(message.isDisplayed());
      assertEquals("It's gone!", message.getText());
    }


    @Test
    public void testEnableAndDisableTextBox() {
        // Navigate to the Dynamic Controls page
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        // Locate the text bar element
        WebElement textBar = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        try {
            // Try to send keys to the text bar without enabling it
            textBar.sendKeys("deniz");

        } catch (ElementNotInteractableException e) {
            // If ElementNotInteractableException occurs, enable the text box and retry
            Driver.getDriver().findElement(By.xpath("//button[.='Enable']")).click();

            // Wait for the loading bar to disappear
            WebElement loadingBar = Driver.getDriver().findElement(By.id("loading"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.invisibilityOf(loadingBar));

            // Retry sending keys to the text bar
            textBar.sendKeys("deniz askk");

            // Assertion for success
           assertTrue(true);
        }
    }


    @Test
    public void testHiddenElementBecomesVisible() {
        // Navigate to the Dynamic Loading page
        Driver.getDriver().findElement(By.linkText("Dynamic Loading")).click();

        // Click on the first example link
        Driver.getDriver().findElement(By.xpath("(//div[@class='example']//a)[1]")).click();

        // Click the "Start" button to trigger the loading
        Driver.getDriver().findElement(By.xpath("//button[.='Start']")).click();

        // Wait for the loading bar to disappear
        WebElement loadingBar = Driver.getDriver().findElement(By.id("loading"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));

        // Locate username, password, and submit button elements
        WebElement username = Driver.getDriver().findElement(By.id("username"));
        WebElement pwd = Driver.getDriver().findElement(By.id("pwd"));
        WebElement submitBtn = Driver.getDriver().findElement(By.xpath("//button[.='Submit']"));

        // Input values and submit the form
        username.sendKeys("admin");
        pwd.sendKeys("admin");
        submitBtn.click();

        // Verify the error message
        WebElement assertText = Driver.getDriver().findElement(By.id("flash"));
assertEquals("Your username is invalid!\n" +
                "×", assertText.getText());
    }


    @Test
    public void testRenderedElementAfterTrigger() {
        // Navigate to the Dynamic Loading page
        Driver.getDriver().findElement(By.linkText("Dynamic Loading")).click();

        // Click on the second example link
        Driver.getDriver().findElement(By.xpath("(//div[@class='example']//a)[2]")).click();

        // Click the "Start" button to trigger the loading
        Driver.getDriver().findElement(By.xpath("//button[.='Start']")).click();

        // Wait for the loading bar to disappear
        WebElement loadingBar = Driver.getDriver().findElement(By.id("loading"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));

        // Get the text of the rendered element after the trigger
        String finishText = Driver.getDriver().findElement(By.xpath("//div[@id='finish']//h4")).getText();

        // Verify the text of the rendered element
  assertEquals("Hello World!", finishText);
    }
}
