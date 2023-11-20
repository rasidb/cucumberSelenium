package com.pom;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownload_pom {
    public UploadAndDownload_pom() {
        Driver.getDriver().get("https://demoqa.com/");
        WebElement element = Driver.getDriver().findElement(By.xpath("//h5[.='Elements']"));
        BrowserUtils.scrollByJs(element);
        element.click();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "downloadButton")
    public WebElement downloadButton;
    @FindBy(id = "uploadFile")
    public WebElement uploadFile;
    @FindBy(id = "uploadedFilePath")
    public WebElement uploadedFilePath;


}
