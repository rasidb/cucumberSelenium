package com.junitTests.topics;

import com.utilities.Driver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test_Basics {
   // @DisplayName("element attribute çağır")
    @Test
    public void getAttribute(){
        Driver.getDriver().get("https://tr.wikipedia.org/wiki/Anasayfa");
        WebElement searchBox = Driver.getDriver().findElement(By.className("cdx-text-input__input"));
        searchBox.sendKeys("Philadelphia Deneyi"+ Keys.ENTER);
        List<WebElement> einsteinTexts = Driver.getDriver().findElements(By.partialLinkText("einstein"));
        for (WebElement element : einsteinTexts) {
            String title = element.getAttribute("title");
            System.out.println("title is: "+title);
            Assert.assertTrue(title.contains("einstein"));
        }
    }

}
