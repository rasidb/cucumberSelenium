package com.stepDefinitions;

import com.pages.NestedFrames_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NestedFrames_stepDefinition  extends NestedFrames_page {
    @Given("kullanıcı nestedFrames sayfasına gider")
    public void kullanıcı_nested_frames_sayfasına_gider() {
        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
        nestedFramesPage.click();
    }

    @And("ilk frameye içindeki {string} yazısının varlığını doğrular")
    public void ilkFrameyeIçindekiYazısınınVarlığınıDoğrular(String parentFrameText) {
        Driver.getDriver().switchTo().frame(parentFrame);
     assertTrue(frameText.isDisplayed());
     assertEquals(parentFrameText,frameText.getText());
    }

    @And("nested frame içindeki {string} yazısını doğrular")
    public void nestedFrameIçindekiYazısınıDoğrular(String innerFrameText) {
        Driver.getDriver().switchTo().frame(innerFrame);
        assertEquals(innerFrameText,frameText.getText());
    }
}
