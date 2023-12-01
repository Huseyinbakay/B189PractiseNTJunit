package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C04 extends BaseClass {


    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin


    @Test
    public void test() {

        driver.get("https://www.google.com/");
       boolean pageTitle= driver.getTitle().contains("Google");

        Assert.assertTrue(pageTitle);

        driver.findElement(By.id("APjFqb")).sendKeys("Nutella", Keys.ENTER);

      String result=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();

      String [] split=result.split(" ");

      String resultNum=split[1];

      String sonucStr=resultNum.replace(".","");

      double sonuc=Double.valueOf(sonucStr);

      Assert.assertTrue(sonuc>100000000);


    }
}
