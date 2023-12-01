package practise_03;

import Utilities.BaseClass;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ScreenShots extends BaseClass {


    @Test
    public void test01() throws IOException {


        // https://www.amazon.com/ adresine gidin


        driver.get("https://www.amazon.com/");

        driver.navigate().refresh();
        driver.navigate().refresh();
        // arama kutusuna Nutella yazip aratın

        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        TakesScreenshot ts= (TakesScreenshot) driver;
        String date= DateTimeFormatter.ofPattern("ddMMMyyyyHHmmss").format(LocalDateTime.now());

        String dosyaYolu="C:\\Users\\asus\\IdeaProjects\\B189SeleniumPractiseJunit\\src\\test\\java\\Utilities\\screen\\"+date+"amazon.jpeg";


       Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));


        // tüm sayfanın fotografını cekin








    }
}
