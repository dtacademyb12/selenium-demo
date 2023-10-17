package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebelementMethods2 {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null ;
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait is a dynamic wait
            // that waits till the element is found
            driver.navigate().to("https://www.dice.com/");

            driver.findElement(By.id("typeaheadInput")).sendKeys("SDET", Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.id("typeaheadInput")).clear();
            driver.findElement(By.id("typeaheadInput")).sendKeys("Automation Engineer");












//
        }finally {
            Thread.sleep(2000);
            driver.quit();
        }


    }
}
