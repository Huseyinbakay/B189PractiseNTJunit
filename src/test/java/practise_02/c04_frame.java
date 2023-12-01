package practise_02;

import Utilities.BaseClass;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c04_frame extends BaseClass {

    @Test
    public void test() {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz


        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();



        // Videoyu izlemek icin Play tusuna basiniz

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']")));

        WebElement playButton=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();
        // videoyu durdurunuz
        waitFor(5);

        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();


        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        // Videoyu calistirdiginizi test ediniz
        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz





    }
}
