package com.stepDefinitions;

import com.pom.Alerts_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_stepDefinition extends Alerts_pom {
    @Given("the user is on the alert page")
    public void the_user_is_on_the_alert_page() {

        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
        alertsPage.click();
    }

    @When("the user clicks the Alert Button")
    public void theUserClicksTheAlertButton() {
        alertButton.click();
        Driver.getDriver().switchTo().alert().accept();

    }

    @Then("an alert should appear after five seconds")
    public void anAlertShouldAppearAfterFiveSeconds() {
        timerAlertButton.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
    }


    @Then("a confirm box should appear with the message {string}")
    public void aConfirmBoxShouldAppearWithTheMessage(String arg0) {
        confirmButton.click();
        Driver.getDriver().switchTo().alert().dismiss();
        Assert.assertEquals(arg0, confirmResult.getText());
    }

    @Then("a prompt box should appear with the message {string}")
    public void aPromptBoxShouldAppearWithTheMessage(String expected) {
        promtButton.click();
        Driver.getDriver().switchTo().alert().sendKeys("rasid");
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(expected, promptResult.getText());
    }
}
