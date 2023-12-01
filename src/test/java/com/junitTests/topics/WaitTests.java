package com.junitTests.topics;

import com.utilities.Driver;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitTests {

    @BeforeAll
    public static void init() {
        // Navigate to the practice website
        Driver.getDriver().get("https://practice.cydeo.com/");
    }


    @DisplayName("Handle WebDriverWait class")
    @Test
    void testWaitForElementToDisappear() {
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
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("It's gone!", message.getText());
    }

    @DisplayName("Enable and Disable the TextBox")
    @Test
    void testEnableAndDisableTextBox() {
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
            Assertions.assertTrue(true);
        }
    }

   @DisplayName("Example 1: Element on Page Hidden and Becomes Visible After Trigger")
    @Test
    void testHiddenElementBecomesVisible() {
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
        Assertions.assertEquals("Your username is invalid!\n" +
                "×", assertText.getText());
    }

    @DisplayName("Example 2: Element on the Page Rendered After the Trigger")
    @Test
    void testRenderedElementAfterTrigger() {
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
        Assertions.assertEquals("Hello World!", finishText);
    }
}
