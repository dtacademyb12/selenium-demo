package day5;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSExecutor {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.duotech.io/");

//            driver.findElement(By.xpath("//a[.='Logo & Brand Identity']")).click();
            //ElementNotInteractableException: element not interactable

//           JavascriptExecutor js =  (JavascriptExecutor)driver;
//           js.executeScript("arguments[0].click;", driver.findElement(By.xpath("//a[.='Logo & Brand Identity']")));



            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2500);");
            Thread.sleep(1000);
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -500);");







        }finally {
            Thread.sleep(3000);
            driver.quit();
        }

    }
}
