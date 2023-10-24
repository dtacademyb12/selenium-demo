package day6;

import day4.SeleniumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshots {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));




            driver.get("https://www.instagram.com/");


            driver.findElement(By.name("username")).sendKeys("ibiza1988");
            driver.findElement(By.name("password")).sendKeys("passwordcsa", Keys.ENTER);

            throw new RuntimeException("test failed");


            // If the implicit wait is over and the element is not found, NoSuchElementException is thrown





            



        }catch (RuntimeException e){

           TakesScreenshot screenshot = (TakesScreenshot)driver;
           File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(screenshotAs, new File("src/test/java/day6/file.png"));

//            SeleniumUtils.takeScreenshot(driver, "src/test/java/day6/file2.png");


        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
