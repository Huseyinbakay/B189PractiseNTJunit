package practise_02;

import Utilities.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C03_Iframe extends BaseClass{

    @Test
    public void test() {
        // https://html.com/tags/iframe sayfasına gidiniz

        driver.get("https://html.com/tags/iframe");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();





        // Videoyu görecek kadar asagiya ininiz
        // Videoyu izlemek icin Play tusuna basiniz


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']")));




        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // Videoyu calistirdiginizi test ediniz
        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz







    }
}
