package practise_02;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends BaseClass {
    @Test
    public void test01() {

        // https://demoqa.com/droppable adresine gidiniz

        driver.get(" https://demoqa.com/droppable");


        // 'Drag me' kutusunu tutup 'Drop here' kutusunun ustune birakiniz

        Actions actions=new Actions(driver);
        WebElement drag=driver.findElement(By.xpath("//div[.='Drag me']"));
        WebElement drop=driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[1]"));
        actions.dragAndDrop(drag,drop).perform();

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz

        WebElement webElement1=driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertTrue(webElement1.isDisplayed());









    }
}
