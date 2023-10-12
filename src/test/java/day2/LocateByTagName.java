package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

public class LocateByTagName {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;
        try{
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            driver.get("https://en.wikipedia.org/wiki/Main_Page");

       //     System.out.println(driver.findElement(By.tagName("h2")).getText());

            // Locate all links and print their text

            List<WebElement> links = driver.findElements(By.tagName("a"));

            System.out.println("This page has " + links.size()+ " links");

            driver.findElements(By.tagName("a")).forEach(s -> System.out.println(s.getText()));


        } finally {
            Thread.sleep(2000);
             driver.quit();
        }


        }
}
