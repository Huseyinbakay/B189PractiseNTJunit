package practise_02;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions_Iframe extends BaseClass {

    @Test
    public void test() {

        // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz

        driver.get("https://demo.automationtesting.in/Vimeo.html");

        // ust bolumde bulunan Video menusunun acilmasi icin mouse'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
        Actions actions =new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a[.='Video']"))).perform();

        driver.findElement(By.xpath("//a[.='Vimeo']")).click();


        // play tusuna basınız.

        driver.switchTo().frame(driver.findElement(By.id("foo")));




        driver.findElement(By.xpath("//*[@class='PlayButton_module_playIcon__fc6bec57']")).click();
        // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz

        driver.switchTo().defaultContent();

        actions.sendKeys(Keys.PAGE_UP).perform();

        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


    }
}
