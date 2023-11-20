package com.pom;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogs_pom {
    public ModalDialogs_pom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Modal Dialogs']")
    public WebElement modalDialogsPage;

      @FindBy(id = "showSmallModal")
    public WebElement showSmallModal;

      @FindBy(id = "example-modal-sizes-title-sm")
    public WebElement smallModalBody;

      @FindBy(id = "closeSmallModal")
    public WebElement closeSmallModal;

      @FindBy(id = "showLargeModal")
    public WebElement showLargeModal;

      @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement largeModelText;

      @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModal;
}
