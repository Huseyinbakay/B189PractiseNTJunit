package Utilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {

   protected WebDriver driver;

    @Before
    public void setUp() throws Exception {

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


    @After
    public void tearDown() throws Exception {



    }

    public void waitFor(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public void tumSayfaScreenshot(String sayfaAdi){
        String tarih= DateTimeFormatter.ofPattern("yyMMddHHmmss").format(LocalDateTime.now());
        String dosyaYolu="src\\test\\java\\utilities\\tumSayfaScreenshot\\"+sayfaAdi+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
