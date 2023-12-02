package com.stepDefinitions;

import com.pages.ModalDialogs_page;
import com.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;


public class ModalDialogs_stepDefinition extends ModalDialogs_page {
    @Given("I navigate to the Modal Dialogs page")
    public void ı_navigate_to_the_modal_dialogs_page() {
        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
        modalDialogsPage.click();
    }

    @When("I click on the small modal button")
    public void ıClickOnTheSmallModalButton() {
        showSmallModal.click();

    }

    @Then("the small modal should be displayed")
    public void theSmallModalShouldBeDisplayed() {
   assertEquals("Small Modal",smallModalBody.getText());
        closeSmallModal.click();
    }

    @When("I click on the large modal button")
    public void ıClickOnTheLargeModalButton() {
        showLargeModal.click();
    }

    @Then("the large modal should be displayed")
    public void theLargeModalShouldBeDisplayed() {
    assertEquals("Large Modal",largeModelText.getText());
   closeLargeModal.click();
    }

}
