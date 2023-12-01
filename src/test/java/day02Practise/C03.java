package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03 extends BaseClass {


    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin


    @Test
    public void test01() {

        driver.get("https://www.bestbuy.com/");

       String pageTitle= driver.getTitle();

        Assert.assertTrue(pageTitle.contains("Best"));

       WebElement webElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

       Assert.assertTrue(webElement.isDisplayed());


       WebElement webElement1=driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));

       Assert.assertTrue(webElement1.isDisplayed());



    }
}
