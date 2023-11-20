package com.stepDefinitions;

import com.pom.TextBox_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class TextBox_stepDefinition extends TextBox_pom {
    @Given("user clicks Text Box button")
    public void userClicksTextBoxButton() {
        BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Text Box']")).click();
    }

    @Given("fill the form")
    public void fill_the_form() {
        usernameElement.sendKeys(username);
        emailElement.sendKeys(email);
        currentAddressElement.sendKeys(adress);
        permanentAddressElement.sendKeys(adress);
        BrowserUtils.scrollByJs(submitBtnElement);
        submitBtnElement.click();
    }

    @Then("assert all informations are correct")
    public void assert_all_informations_are_correct() {

        assertEquals(username, assertNameElement.getText().replace("Name:", ""));
        assertEquals(email, assertEmailElement.getText().replace("Email:", ""));

    }


}
