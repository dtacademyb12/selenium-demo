package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InstagramLogin {

    public static void main(String[] args) throws InterruptedException {


        // Navigate to instagram.com


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.instagram.com/");

        Thread.sleep(500);
        // Enter valid username and invalid password
        driver.findElement(By.name("username")).sendKeys("Duotech");
        //NoSuchElementException: no such element:
        driver.findElement(By.name("password")).sendKeys("helloworld", Keys.ENTER);

         Thread.sleep(1000);
        // Verify that the error message is "Sorry, your password was incorrect. Please double-check your password."
        WebElement actualErrorMessage = driver.findElement(By.className("_ab2z"));
        String textOfErrorMessage = actualErrorMessage.getText();
//        System.out.println(textOfErrorMessage);

        Assert.assertEquals(textOfErrorMessage,  "Sorry, your password was incorrect. Please double-check your password.");


        driver.quit();



    }
}
