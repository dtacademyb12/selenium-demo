package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ImplicitWait {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null ;
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait is a dynamic wait
            // that waits till the element is found
            driver.navigate().to("https://www.instagram.com/");

//            Thread.sleep(500); // static wait
            // Enter valid username and invalid password
            driver.findElement(By.name("username")).sendKeys("Duotech");
            //NoSuchElementException: no such element:
            driver.findElement(By.name("password")).sendKeys("helloworld", Keys.ENTER);

//            Thread.sleep(1000);
            // Verify that the error message is "Sorry, your password was incorrect. Please double-check your password."
            WebElement actualErrorMessage = driver.findElement(By.className("_ab2z"));
            String textOfErrorMessage = actualErrorMessage.getText();
//        System.out.println(textOfErrorMessage);

            Assert.assertEquals(textOfErrorMessage, "Sorry, your password was incorrect. Please double-check your password.");

        }finally {
            Thread.sleep(3000);
            driver.quit();
        }



    }
}
