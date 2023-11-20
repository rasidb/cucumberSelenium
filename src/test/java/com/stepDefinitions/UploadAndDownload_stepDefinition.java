package com.stepDefinitions;

import com.pom.UploadAndDownload_pom;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadAndDownload_stepDefinition extends UploadAndDownload_pom {
    @Given("user clicks Upload and Download button")
    public void userClicksUploadAndDownloadButton() {
        BrowserUtils.setupDemoqaMenu("Elements");
        Driver.getDriver().findElement(By.xpath("//span[.='Upload and Download']")).click();

    }

    @And("waits for the file to download")
    public void waitsForTheFileToDownload() {
        downloadButton.click();
        String filePath = "C:\\Users\\Noob\\Downloads\\sampleFile.jpeg";
        BrowserUtils.waitForFileToDownload(filePath);
    }

    @And("upload a file")
    public void uploadAFile() {
        String filePath = "C:\\Users\\Noob\\Downloads\\sampleFile.jpeg";
        uploadFile.sendKeys(filePath);

    }

    @Then("checks that the file is uploaded")
    public void checksThatTheFileIsUploaded() {
        Assert.assertTrue(uploadedFilePath.isDisplayed());
    }


}