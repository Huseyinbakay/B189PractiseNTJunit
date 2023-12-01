package day02Practise;

import Utilities.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class C09_Alert extends BaseClass {


    @Test
    public void test01() throws InterruptedException {

        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");


        //customer id kısmına "53920 yazın

        Thread.sleep(2500);

        driver.findElement(By.name("cusid")).sendKeys("53920 ");


        //submit butonuna tıklayın

        driver.findElement(By.name("submit")).click();
        //cıkan alert mesajını yazdırın
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        Thread.sleep(2500);

        //alerti kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2500);
        //cıkan 2. alert mesajını yazdırın

        System.out.println("driver.switchTo().alert().getText() 2. Alert = " + driver.switchTo().alert().getText());
        //cıkan 2. alerti kabul edin
        Thread.sleep(2500);
        driver.switchTo().alert().accept();


    }
}
