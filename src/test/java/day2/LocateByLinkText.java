package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateByLinkText {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;
        try{
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            driver.get("https://en.wikipedia.org/wiki/Main_Page");

//            driver.findElement(By.linkText("anyone can edit")).click();
    //        driver.findElement(By.linkText("Three earthquakes")).click();

            driver.findElement(By.partialLinkText("can edit")).click();


      } finally {
            Thread.sleep(2000);
             driver.quit();
        }


        }
}
