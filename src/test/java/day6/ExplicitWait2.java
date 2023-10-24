package day6;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait2 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // POLLING FREQUENCY -> 0.5 seconds


            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");


            driver.findElement(By.xpath("//button[.='Start']")).click();



//            WebElement inputBox = driver.findElement(By.xpath("//h4[.='Hello World!']"));

            //wait till the element is present

            // If you need to mix implicit and explicit wait, first set the implicit wait back to zero and re-set it afterward
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[.='Hello World!']")));

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            SeleniumUtils.waitTillElementIsPresent(driver, By.xpath("//h4[.='Hello World!']"), 5);

//            SeleniumUtils.waitFor(3);
            //TimeoutException:
           // Expected condition failed: waiting for presence of element located by: By.xpath: //h4[.='Hello World!'] (tried for 2 second(s) with 500 milliseconds interval)


            System.out.println(driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());







            // If the implicit wait is over and the element is not found, NoSuchElementException is thrown








            



        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
