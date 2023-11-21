package com.junitTests.topics;

import com.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DakikadaKackelime {
    @Test
    public void kacKelime() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //fast fingers sitesine git
        Driver.getDriver().get("https://10fastfingers.com/typing-test/turkish");
        //kelimelerin yazılacağı input
        WebElement inputField = Driver.getDriver().findElement(By.id("inputfield"));
        //cookie bazen çıkıp bazen çıkmadığı için try bloğu içinde
        try {
            //cookie elementi
            WebElement cookiezElement = Driver.getDriver().findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
            //cookie elementi tıklanana kadar bekel ve tıkla
            wait.until(ExpectedConditions.elementToBeClickable(cookiezElement)).click();
        } catch (Exception e) {
            //exception yakalarsa cookie yok demektir herhangi bi komuta gerek yok
        }
        boolean whileCheck=true;
        //tüm kelimeler bittiği zaman break whileCheck false olarak değiştirilecek ve program sonlanacak
        while (whileCheck) {
            //yazılacak tüm satırları list olarak toplayan komut
            List<WebElement> words = Driver.getDriver().findElements(By.xpath("//div[@id='row1']//span"));
            //listteki tüm elementleri inputField elementine yazacağımız için for döngüsüne alıyoruz
            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i).getText();
                //currentWordden sonraki kelime eğer ki hiçliğe eşitse başka bi kelime yazılmayacağı için boşluk koymuyoruz(koyarsak hatalı kelime sayıyor)
                WebElement timerElement = Driver.getDriver().findElement(By.id("timer"));
                if (timerElement.getText().equals("0:00")) {
                   whileCheck=false;
                } else {
                    //ilk kelimeyle sonraki kelime arasına boşluk koymak gerekiyor ki diğer kelimeye geçsin
                    inputField.sendKeys(currentWord + " ");
                }
                //eğer ki words listinge i+1. element yoksa tüm kelimeler bittiği için program kapanabilir test başarılı
                try {
                    if (words.get(i + 1).getText().equals("")) {
                    }
                } catch (IndexOutOfBoundsException e) {
                    whileCheck=false;
                }
            }
        }
        Assert.assertTrue(true);
        Driver.closeDriver();
    }
}

