package day5;

import day4.SeleniumUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSAlerts {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

             // Basic Alert
//            driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
//            Thread.sleep(2000);
//            //UnhandledAlertException: unexpected alert open: {Alert text : I am a JS Alert}
//
//            Alert alert = driver.switchTo().alert();
//            alert.accept(); // clicking OK

            // Confirm Alert
//            driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//            Thread.sleep(2000);
//
//
//            Alert alert = driver.switchTo().alert();
//            alert.dismiss(); // clicking Cancel


            // Prompt alert

            driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
//            Thread.sleep(2000);


            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.sendKeys("NewPlaylist"); // type
            Thread.sleep(2000);
            System.out.println(alert.getText());
            alert.accept();




           // input[placeholder=First]

            driver.findElement(By.linkText("Elemental Selenium")).click();


        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
