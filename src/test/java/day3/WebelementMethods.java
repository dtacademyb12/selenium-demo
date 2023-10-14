package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebelementMethods {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null ;
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait is a dynamic wait
            // that waits till the element is found
            driver.navigate().to("https://www.skysports.com/");

            driver.switchTo().frame("sp_message_iframe_859762");

            driver.findElement(By.xpath("//button[@title='Accept all']")).click();

            // Find a link and get its href attribute value

            System.out.println(driver.findElement(By.xpath("//a[@href='/football/england-vs-australia/report/481469']")).getAttribute("href"));
            System.out.println(driver.findElement(By.xpath("//a[@href='/football/england-vs-australia/report/481469']")).getAttribute("class"));
           driver.findElement(By.linkText("Log In")).click();
           driver.findElement(By.id("username")).sendKeys("blabla@gmail.com");
//            System.out.println( driver.findElement(By.id("username")).getText());
            System.out.println( driver.findElement(By.id("username")).getAttribute("value"));

            // any input element's text/content cannot be grabbed with getText()








//
        }finally {
            Thread.sleep(1000);
            driver.quit();
        }


    }
}
