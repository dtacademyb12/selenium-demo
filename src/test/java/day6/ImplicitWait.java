package day6;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplicitWait {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // POLLING FREQUENCY -> 0.5 seconds


            driver.get("https://www.instagram.com/");


            driver.findElement(By.name("username")).sendKeys("ibiza1988");
            driver.findElement(By.name("password")).sendKeys("password", Keys.ENTER);


            // If the implicit wait is over and the element is not found, NoSuchElementException is thrown





            



        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
