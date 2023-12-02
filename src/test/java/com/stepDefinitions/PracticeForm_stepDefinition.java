package com.stepDefinitions;

import com.pages.PracticeForm_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;


public class PracticeForm_stepDefinition extends PracticeForm_page {

    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() {
        BrowserUtils.setupDemoqaMenu("Forms");
    }

    @When("the user clicks on the practice form")
    public void theUserClicksOnThePracticeForm() {
        practiceFormPage.click();
    }

    @And("fills out the practice form")
    public void fillsOutThePracticeForm() {
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        firstName.sendKeys(firstNameStr);
        lastName.sendKeys(lastNameStr);
        userEmail.sendKeys(userMailStr);
        Driver.getDriver().findElement(By.xpath("//label[.='Male']")).click();
        assertTrue(maleGender.isSelected());
        Driver.getDriver().findElement(By.xpath("//label[.='Female']")).click();
        assertTrue(femaleGender.isSelected());
        assertFalse(maleGender.isSelected());
        userNumber.sendKeys(userNumberStr);
        BrowserUtils.scrollByJs(dateOfBirthInput);
        dateOfBirthInput.click();
        Select select =new Select(selectMonth);
        select.selectByVisibleText("May");
        select=new Select(selectYear);
        select.selectByVisibleText("1999");
        selectDay.click();
        WebElement sportsElement = Driver.getDriver().findElement(By.xpath("//label[.='Sports']"));
        wait.until(ExpectedConditions.elementToBeClickable(sportsElement)).click();
        Driver.getDriver().findElement(By.xpath("//label[.='Reading']")).click();
        Driver.getDriver().findElement(By.xpath("//label[.='Music']")).click();
        assertTrue(hobbies_sports.isSelected());
        assertTrue(hobbies_reading.isSelected());
        assertTrue(hobbies_music.isSelected());
        uploadPicture.sendKeys("C:\\Users\\Noob\\Desktop\\Adsız.png");
        BrowserUtils.scrollByJs(currentAddress);
        currentAddress.sendKeys("siwas"+ Keys.TAB+"NCR"+Keys.TAB+"Noida"+Keys.TAB+Keys.ENTER);
    }

    @Then("submits the form")
    public void submitsTheForm() {
        List<WebElement> checkElements = Driver.getDriver().findElements(By.xpath("(//tbody//tr)//td[2]"));
        assertEquals(firstNameStr+" "+lastNameStr,checkElements.get(0).getText());
        assertEquals(userMailStr,checkElements.get(1).getText());
        assertEquals("Female",checkElements.get(2).getText());
        assertEquals(userNumberStr,checkElements.get(3).getText());
        assertEquals("09 May,1999",checkElements.get(4).getText());
        assertEquals("Sports, Reading, Music",checkElements.get(6).getText());
        assertEquals("Adsız.png",checkElements.get(7).getText());
        assertEquals("siwas",checkElements.get(8).getText());

    }
}
