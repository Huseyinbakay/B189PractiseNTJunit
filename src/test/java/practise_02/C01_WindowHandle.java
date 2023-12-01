package practise_02;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C01_WindowHandle extends BaseClass {

    @Test
    public void test() {

        // 1- https://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com");

        // 2- url'in 'amazon' icerdigini test edelim

        String amazonHandle=driver.getWindowHandle();

        String action=driver.getCurrentUrl();
        Assert.assertTrue(action.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

       String bestHandle= driver.getWindowHandle();


        // 4- title'in 'Best Buy' icerdigini test edelim

        Assert.assertTrue( driver.getTitle().contains("Best Buy"));


        // 5- ilk sayfaya(amazon) donup sayfada java aratalım

       driver.switchTo().window(amazonHandle);

       driver.navigate().refresh();
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim

        String rwxt= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(rwxt.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim

        driver.switchTo().window(bestHandle);

        // 8- logonun gorundugunu test edelim
        WebElement webElement=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(webElement.isDisplayed());










    }
}
