package practise_03;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileUpload extends BaseClass {

    @Test
    public void test01() {


        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.


        String dosyaYolu="\\Desktop\\Yeni Microsoft Word Belgesi.docx";
        String ortakYol=System.getProperty("user.home");
        String path=ortakYol+dosyaYolu;



        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.name("note")).sendKeys("Benim Dosyam");
        driver.findElement(By.name("upfile")).sendKeys(path);

        waitFor(3);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
        // 'Press' butonuna basın

        driver.findElement(By.xpath("//input[@value='Press']")).click();
        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


        WebElement dosyaNotu= driver.findElement(By.tagName("blockquote"));
        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());
        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.
        WebElement dosyaIcerigi=driver.findElement(By.tagName("pre"));
        Assert.assertEquals("Merhaba Dunya",dosyaIcerigi.getText());



    }
}
