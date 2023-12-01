package com.junitTests.topics;

import com.utilities.Driver;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

class Test_Basics {
   @DisplayName("element attribute çağır")
    @Test
   void getAttribute(){
        Driver.getDriver().get("https://tr.wikipedia.org/wiki/Anasayfa");
        WebElement searchBox = Driver.getDriver().findElement(By.className("cdx-text-input__input"));
        searchBox.sendKeys("Philadelphia Deneyi"+ Keys.ENTER);
        List<WebElement> einsteinTexts = Driver.getDriver().findElements(By.partialLinkText("einstein"));
        for (WebElement element : einsteinTexts) {
            String title = element.getAttribute("title");
            System.out.println("title is: "+title);
            Assertions.assertTrue(title.contains("einstein"));
        }
    }

}
