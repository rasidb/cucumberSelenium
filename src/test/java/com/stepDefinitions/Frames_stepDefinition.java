package com.stepDefinitions;

import com.pom.Frames_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Frames_stepDefinition extends Frames_pom {
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
        Assert.assertEquals(expectedText,textFromInnerFrame.getText());
    }

    @And("I switch back to the main iframe")
    public void ıSwitchBackToTheMainIframe() {
    Driver.getDriver().switchTo().defaultContent();
    Assert.assertTrue(framesPage.isDisplayed());
    }
}
