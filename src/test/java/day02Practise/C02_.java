package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_ extends BaseClass {

    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin


    @Test
    public void terst01() {

        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        driver.get("https://www.amazon.com/");

        driver.navigate().refresh();
        driver.navigate().refresh();

       WebElement webElement= driver.findElement(By.id("twotabsearchtextbox"));

     String actualTag=  webElement.getTagName();

     String expectedTag="input";

        Assert.assertEquals(expectedTag,actualTag);


       String actualAttribute= webElement.getAttribute("name");

       String expectedAttribute="field-keywords";

       Assert.assertEquals(expectedAttribute,actualAttribute);









    }
}
