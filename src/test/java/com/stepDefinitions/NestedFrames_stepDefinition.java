package com.stepDefinitions;

import com.pom.NestedFrames_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;


public class NestedFrames_stepDefinition  extends NestedFrames_pom {
    @Given("kullanıcı nestedFrames sayfasına gider")
    public void kullanıcı_nested_frames_sayfasına_gider() {
        BrowserUtils.setupDemoqaMenu("Alerts, Frame & Windows");
        nestedFramesPage.click();
    }

    @And("ilk frameye içindeki {string} yazısının varlığını doğrular")
    public void ilkFrameyeIçindekiYazısınınVarlığınıDoğrular(String parentFrameText) {
        Driver.getDriver().switchTo().frame(parentFrame);
        Assert.assertTrue(frameText.isDisplayed());
        Assert.assertEquals(parentFrameText,frameText.getText());
    }

    @And("nested frame içindeki {string} yazısını doğrular")
    public void nestedFrameIçindekiYazısınıDoğrular(String innerFrameText) {
        Driver.getDriver().switchTo().frame(innerFrame);
        Assert.assertEquals(innerFrameText,frameText.getText());
    }
}
