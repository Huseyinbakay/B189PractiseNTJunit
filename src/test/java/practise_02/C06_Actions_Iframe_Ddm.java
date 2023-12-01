package practise_02;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class C06_Actions_Iframe_Ddm extends BaseClass {


    @Test
    public void test() {




        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");


        driver.navigate().refresh();
        driver.navigate().refresh();



        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement webElement1=driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 icp-link-style-2']"));

        actions.sendKeys().moveToElement(webElement1).perform();
        // Change country/region butonuna basiniz

        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz

        WebElement ddr= driver.findElement(By.id("icp-dropdown"));


        Select select=new Select(ddr);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//*[.='Changing country/region website']")).click();


        // Go to website butonuna tiklayiniz
        driver.findElement(By.className("a-button-input")).click();

         Set<String> tumHadleler1=driver.getWindowHandles();
         String tumHadleler=tumHadleler1.toArray()[1].toString();





        String yeniSayfaHandle=driver.getWindowHandle();











        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        driver.switchTo().window(tumHadleler);
        System.out.println("driver.getTitle() = " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Elektronik"));








    }
}
