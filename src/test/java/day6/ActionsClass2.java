package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass2 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();



            driver.get("https://www.duotech.io/");


            Actions actions = new Actions(driver);

            Thread.sleep(2000);

            actions.doubleClick(driver.findElement(By.tagName("h1"))).perform();













        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
