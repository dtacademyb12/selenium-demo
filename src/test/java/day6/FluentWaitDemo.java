    package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

    public class FluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();


            // POLLING FREQUENCY -> 0.5 seconds


            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");


            driver.findElement(By.xpath("//button[.='Start']")).click();


            Wait<WebDriver> wait =  new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(2)) // polling frequency can be changed
                    .ignoring(NoSuchElementException.class); // exceptions ignored while waiting

//            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//                public WebElement apply(WebDriver driver) {
//                    return driver.findElement(By.xpath("//h4[.='Hello World!']"));
//                }
//            });

             wait.until(webdriver -> webdriver.findElement(By.xpath("//h4[.='Hello World!']")).isDisplayed());

            System.out.println(driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());


        }finally {

            driver.quit();
        }


    }
}
