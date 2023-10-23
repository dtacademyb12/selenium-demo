package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // POLLING FREQUENCY -> 0.5 seconds


            driver.get("https://the-internet.herokuapp.com/dynamic_controls");


            driver.findElement(By.xpath("//button[.='Enable']")).click();



//            WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
//
//            //wait till the element is intearctable
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.elementToBeClickable(inputBox));

            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));


            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ibiza1988");



            // If the implicit wait is over and the element is not found, NoSuchElementException is thrown





            



        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
