package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Check_Box extends BaseClass {

    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement button1=driver.findElement(By.id("vfb-7-1"));
        WebElement button2=driver.findElement(By.id("vfb-7-2"));
        WebElement button3=driver.findElement(By.id("vfb-7-3"));



        if (!button1.isSelected()){

            button1.click();

        }

        Thread.sleep(3000);

        if (!button2.isSelected()){

            button2.click();
        }


        Assert.assertTrue(!button1.isSelected());
        Assert.assertTrue(button2.isSelected());


    }
}
