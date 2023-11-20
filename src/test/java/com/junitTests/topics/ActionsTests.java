package com.junitTests.topics;

import com.utilities.Driver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsTests {
    public static Actions actions;

    @Before
    public static void init() {
        // Navigate to the practice website
        Driver.getDriver().get("https://practice.cydeo.com/");
        actions = new Actions(Driver.getDriver());
    }

    //@DisplayName("Drag and Drop Test")
    @Test
     void dragAndDropTest() {

        // Click on the "Drag and Drop" link
        Driver.getDriver().findElement(By.linkText("Drag and Drop")).click();

        // Find the first column and its header
        WebElement firstColumn = Driver.getDriver().findElement(By.xpath("//div[@class='column']"));
        WebElement firstColumnText = firstColumn.findElement(By.xpath(".//header"));
        Assert.assertEquals("A", firstColumnText.getText());

        // Find the second column
        WebElement secondColumn = Driver.getDriver().findElement(By.id("column-b"));

        // Perform drag and drop from the first column to the second column
        actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(firstColumn, secondColumn).perform();

        // After drag and drop, check the text in the first column header
        firstColumn = Driver.getDriver().findElement(By.xpath("//div[@class='column']"));
        firstColumnText = firstColumn.findElement(By.xpath(".//header"));
        Assert.assertEquals("B", firstColumnText.getText());
    }

   // @DisplayName("Move the small circle to the big circle")
    @Test
     void dragAndDropCircles() {
        // Navigate to the Drag and Drop Circles page
        Driver.getDriver().findElement(By.linkText("Drag and Drop Circles")).click();

        // Locate the small and big circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        // Perform drag and drop action
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        // Verify the result
        Assert.assertEquals("You did great!", bigCircle.getText());
    }
}
