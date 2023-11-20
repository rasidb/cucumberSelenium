package com.junitTests.topics;

import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Oys {
    @Test
    public void kodluBakımlar() {
        Driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
        Driver.getDriver().get("https://portal.teias.gov.tr/my.policy");
        Driver.getDriver().findElement(By.linkText("tıklayınız")).click();
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.id("input_1")).sendKeys(ConfigurationReader.get("username"));
        Driver.getDriver().findElement(By.id("input_2")).sendKeys(ConfigurationReader.get("pwd"));
        Driver.getDriver().findElement(By.xpath("//input[@value='Giriş']")).click();
        Driver.getDriver().findElement(By.id("myButton2")).click();
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.id("webtop_header_message"))));
        WebElement oysPage = Driver.getDriver().findElement(By.id("/VPN/OYS"));
        BrowserUtils.scrollByJs(oysPage);
        wait.until(ExpectedConditions.elementToBeClickable(oysPage)).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            if (Driver.getDriver().getTitle().equals("TEİAŞ - OYS")) {
                break;
            } else {
                Driver.getDriver().close();
            }
        }
        Driver.getDriver().findElement(By.id("user_name")).sendKeys(ConfigurationReader.get("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.get("pwd"));
        Driver.getDriver().findElement(By.id("btnLogin")).click();
        WebElement kontrolBakimListesiMain = Driver.getDriver().findElement(By.xpath("//span[.='Kontrol Bakım Listesi']"));
        wait.until(ExpectedConditions.elementToBeClickable(kontrolBakimListesiMain));
        try {
            kontrolBakimListesiMain.click();
        } catch (Exception e) {
            BrowserUtils.wait(1);
            kontrolBakimListesiMain.click();
        }
        WebElement kodluBakım = Driver.getDriver().findElement(By.xpath("//span[.='Kodlu Bakım']"));
        wait.until(ExpectedConditions.elementToBeClickable(kodluBakım)).click();
        while (true) {
            WebElement sorularSayfası = Driver.getDriver().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-id']//img"));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(sorularSayfası)).click();
            } catch (StaleElementReferenceException e) {
                sorularSayfası = Driver.getDriver().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-id']//img"));
                wait.until(ExpectedConditions.elementToBeClickable(sorularSayfası)).click();
            }
            List<WebElement> yesiller = Driver.getDriver().findElements(By.xpath("//td[contains(@class, 'Green')]//img"));
            for (int i = 0; i < yesiller.size(); i++) {
                List<WebElement> element = Driver.getDriver().findElements(By.xpath("//td[contains(@class, 'Green')]//img"));
                element.get(i).click();

                //wait.until(ExpectedConditions.elementToBeClickable(element.get(i))).click();
            }
            Driver.getDriver().findElement(By.xpath("//button[.='Kaydet']")).click();
            Driver.getDriver().findElement(By.xpath("//button[.='Evet']")).click();
        }
    }
}
