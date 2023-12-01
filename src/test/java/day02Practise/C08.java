package day02Practise;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C08 extends BaseClass {


    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin

        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement webElement= driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(webElement);

        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin

        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

        List<WebElement> liste=select.getOptions();

        int actual=liste.size();
        int expected=28;

        Assert.assertTrue(expected==actual);

        // dropdown'daki optionların tamamını yazdırın

        int i=1;
        for (WebElement w:liste) {
            System.out.println(i+".opsiyon   "+w.getText());
            i++;
        }




    }




}
