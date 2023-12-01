package practise_03;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C06 extends BaseClass {

    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // Siparis Ozeti kısmındaki toplam tutarın ekran goruntusunu alınız ve yazdırınız
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin gorundugunu test ediniz
    @Test
    public void test01() {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.id("search-input")).sendKeys("oppo", Keys.ENTER);
        waitFor(2);
        // sonuc yazısını yazdiriniz
        System.out.println(driver.findElement(By.className("plp-panel-block1")).getText());
        // ilk urunun fotografını cekin
        WebElement ilkUrun=driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));
        String tarih= DateTimeFormatter.ofPattern("yyMMddHHmmss").format(LocalDateTime.now());
        String spesifikAd="ilkOppo";
        String dosyaYolu="src\\test\\java\\utilities\\webelementScreenshot\\"+spesifikAd+tarih+".jpeg";
        try {
            Files.write(Paths.get(dosyaYolu),ilkUrun.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            driver.findElement(By.id("button-1580496494")).click();//cookie kapatılacak
        } catch (Exception e) {
            System.out.println("Cookie cikmadi");
        }
        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        waitFor(2);
        // sepete ekleyiniz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.UP,Keys.UP,Keys.UP,Keys.UP).perform();
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        waitFor(2);
        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        // Siparis Ozeti kısmındaki toplam tutarın ekran goruntusunu alınız ve yazdırınız
        WebElement toplamTutar=driver.findElement(By.className("cart-sum-total"));
        spesifikAd ="toplamTutar";
        tarih= DateTimeFormatter.ofPattern("yyMMddHHmmss").format(LocalDateTime.now());
        dosyaYolu="src\\test\\java\\utilities\\webelementScreenshot\\"+spesifikAd+tarih+".jpeg";
        try {
            Files.write(Paths.get(dosyaYolu),toplamTutar.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(toplamTutar.getText());
        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        // "Teknosa'ya hos geldiniz" webelementinin gorundugunu test ediniz
        WebElement hosgeldiniz=driver.findElement(By.className("lrp-title"));
        Assert.assertTrue(hosgeldiniz.isDisplayed());
    }





}
