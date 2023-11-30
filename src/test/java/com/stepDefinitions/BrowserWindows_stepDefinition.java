package com.stepDefinitions;

import com.pages.BrowserWindows_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.Set;

public class BrowserWindows_stepDefinition extends BrowserWindows_page {
    @Given("the user opens the website")
    public void the_user_opens_the_website() {
        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
    }

    @When("the user clicks the Browser Windows button")
    public void theUserClicksTheBrowserWindowsButton() {
        browserWindowsPage.click();
    }

    @Then("a new browser window should open")
    public void aNewBrowserWindowShouldOpen() {
        String mainPage = Driver.getDriver().getWindowHandle();
        tabButton.click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        windowHandles.remove(mainPage);
        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            Assert.assertEquals("This is a sample page",tabWindowText.getText());
            Driver.getDriver().close();
        }
        Driver.getDriver().switchTo().window(mainPage);
        windowHandles=Driver.getDriver().getWindowHandles();
        windowHandles.remove(mainPage);
        newWindow.click();
        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            Assert.assertEquals("This is a sample page",newWindow.getText());
            Driver.getDriver().close();
        }
    }

}
