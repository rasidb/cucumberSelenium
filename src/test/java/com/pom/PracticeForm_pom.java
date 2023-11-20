package com.pom;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeForm_pom {
    public PracticeForm_pom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Practice Form']")
    public WebElement practiceFormPage;


    public String firstNameStr="wooden";
    public String lastNameStr="spoon";
    public String userMailStr="woodenspoon@gmail.com";
    public String userNumberStr="1234567981";

    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "userEmail")
    public WebElement userEmail;
    @FindBy(id = "gender-radio-1")
    public WebElement maleGender;
    @FindBy(id = "gender-radio-2")
    public WebElement femaleGender;
    @FindBy(id = "userNumber")
    public WebElement userNumber;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement selectMonth;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement selectYear;
    @FindBy(xpath = "//div[.='9']")
    public WebElement selectDay;
    @FindBy(id = "hobbies-checkbox-1")
    public WebElement hobbies_sports;
    @FindBy(id = "hobbies-checkbox-2")
    public WebElement hobbies_reading;
    @FindBy(id="hobbies-checkbox-3")
    public WebElement hobbies_music;
    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    public WebElement currentAddress;
}
