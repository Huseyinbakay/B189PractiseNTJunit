package day02Practise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practise {

    // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
    // ilk kutucuga 20 giriniz
    // ikinci kutucuga 30 giriniz
    // calculate'e tıklayınız
    // sonucu yazdırınız
    // sayfayi kapatiniz

    WebDriver driver;


    @Before
    public void setUp() throws Exception {

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

    }


    @After
    public void tearDown() throws Exception {

      //  Thread.sleep(2500);
        //driver.quit();
    }

    @Test
    public void test01() {

        driver.get("https://testpages.herokuapp.com/styled/calculator");

        driver.findElement(By.id("number1")).sendKeys("20");

        driver.findElement(By.id("number2")).sendKeys("30");

        driver.findElement(By.id("calculate")).click();
        String text=driver.findElement(By.id("answer")).getText();

        System.out.println("Sonuç = " + text);
    }
}

