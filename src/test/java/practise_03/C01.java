package practise_03;

import Utilities.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01 extends BaseClass {


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        // some-file.txt dosyasini indirelim
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        driver.get("https://the-internet.herokuapp.com/download");


        String ortakYol="\\Downloads\\some-file.txt";
        String farklıyol=System.getProperty("user.home");
        String path=farklıyol+ortakYol;

        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.xpath("//a[.='some-file.txt']")).click();

        waitFor(5000);

      Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
