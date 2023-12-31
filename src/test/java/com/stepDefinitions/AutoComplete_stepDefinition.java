package com.stepDefinitions;

import com.pages.AutoComplete_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;



import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AutoComplete_stepDefinition extends AutoComplete_page {
    @Given("user clicks widgets menu")
    public void user_clicks_widgets_menu() {
        BrowserUtils.setupDemoqaMenu("Widgets");
    }

    @And("clicks Auto Complete page")
    public void clicksAutoCompletePage() {
        autoCompletePage.click();
    }

    @And("write {string} and {string} in multiple box")
    public void writeAndInMultipleBox(String firstColor, String secColor) {
        autoCompleteMultipleInput.sendKeys(firstColor);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        multipleFirstSelect.click();
        autoCompleteMultipleInput.sendKeys(secColor);
        multipleFirstSelect.click();
        assertEquals(firstColor, firstMultiCheckText.getText());
      assertEquals(secColor, secMultiCheckText.getText());
    }

    @And("write {string} in single box")
    public void writeInSingleBox(String color) {
        autoCompleteSingleInput.sendKeys(color);
        BrowserUtils.scrollByJs(singleSelectFirst);
        singleSelectFirst.click();
  assertEquals(color, singleTextCheck.getText());
    }


}
