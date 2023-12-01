package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C07_Drop_Down extends BaseClass {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin


    @Test
    public void test01() {

        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
       WebElement webElement= driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(webElement);

        select.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);


       WebElement webElement1= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

       String text= webElement1.getText();

        Assert.assertTrue(text.contains("Java"));




    }
}
