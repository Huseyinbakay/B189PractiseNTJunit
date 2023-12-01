package practise_03;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_Waits extends BaseClass {


    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void test01() {


        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz


        WebElement xs=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(xs.isEnabled());
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();
        driver.findElement(By.id("message")).isDisplayed();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(xs));

        // Textbox'in etkin olmadıgını(enable) test edin
        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        // It's enable! mesajının goruntulendigini test edin
        // Textbox'in etkin oldugunu(enable) test edin
        Assert.assertTrue(xs.isEnabled());
    }

    @Test
    public void test02() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin



        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //==>  "It's gone!" yazısının görünür oldugunu test edin.
       WebElement message= driver.findElement(By.id("message"));
       Assert.assertTrue( message.isDisplayed());
      ;




    }
}
