package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Iframes {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.duotech.io/enroll-sqae2");


           //Switch the context of the webdriver to the iframe

            WebElement iframe = driver.findElement(By.xpath("//iframe[starts-with( @id, '16976')]"));
//            driver.switchTo().frame(iframe);
            driver.switchTo().frame(0);

            driver.findElement(By.cssSelector("input[placeholder=First]")).sendKeys("Bobby");

            driver.switchTo().defaultContent(); //switches the context back to the main page

            //  driver.switchTo().parentFrame(); // method that switches from nested inner frame to its direct parent frame

            System.out.println(driver.findElement(By.xpath("//h1[@data-ix]")).getText());



























        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
