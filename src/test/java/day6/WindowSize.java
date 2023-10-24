package day6;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WindowSize {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
//            driver.manage().window().setSize(new Dimension(840,470));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            System.out.println(driver.manage().window().getSize());

//            driver.manage().window().maximize();
//            driver.manage().window().fullscreen();





            driver.get("https://www.duotech.io/");


            Assert.assertFalse(!driver.findElement(By.linkText("LMS")).isDisplayed());



        }finally {
            driver.quit();
        }


    }
}
