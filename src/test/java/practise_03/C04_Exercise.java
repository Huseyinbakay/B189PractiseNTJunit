package practise_03;

import Utilities.BaseClass;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_Exercise extends BaseClass {

    @Test
    public void test() {


        // https://www.teknosa.com/ adresine gidin

        driver.get("https://www.teknosa.com/");

        // arama cubuguna oppo yazip enter'a basınız

        driver.findElement(By.id("search-input")).sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz

        System.out.println("Sonuç       "+driver.findElement(By.className("plp-info")).getText());

        // ilk urunun fotografını

        WebElement ilkUrun=driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));
        String date= DateTimeFormatter.ofPattern("ddMMMyyyyHHmmss").format(LocalDateTime.now());
        String dosyaYol="C:\\Users\\asus\\IdeaProjects\\B189SeleniumPractiseJunit\\src\\test\\java\\Utilities\\webelementScreenshot\\"+date+".jpeg";

        driver.findElement(By.id("ins-editable-button-1580496494")).click();

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()",driver.findElement(By.xpath("(//a[@class=' prd-link '])[1] ")));






        try {
            Files.write(Paths.get(dosyaYol),ilkUrun.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        // cikan ilk urune tiklayiniz

        // sepete ekleyiniz
        // sepetim'e git tilayiniz
        // Siparis Ozeti kısmındaki toplam tutarın ekran goruntusunu alınız ve yazdırınız
        // Alisverisi tamamlayiniz
        // "Teknosa'ya hos geldiniz" webelementinin gorundugunu test ediniz
    }
}
