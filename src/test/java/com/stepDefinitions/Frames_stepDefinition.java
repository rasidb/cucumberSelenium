package com.stepDefinitions;

import com.pages.Frames_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Frames_stepDefinition extends Frames_page {
    @Given("I open the main page")
    public void ı_open_the_main_page() {
        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
        framesPage.click();
    }

    @When("I switch to the iframe")
    public void ıSwitchToTheIframe() {
        Driver.getDriver().switchTo().frame(innerFrame);

    }

    @Then("I should see {string} inside the iframe")
    public void ıShouldSeeInsideTheIframe(String expectedText) {
      assertEquals(expectedText,textFromInnerFrame.getText());
    }

    @And("I switch back to the main iframe")
    public void ıSwitchBackToTheMainIframe() {
    Driver.getDriver().switchTo().defaultContent();
    assertTrue(framesPage.isDisplayed());
    }
}
