package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsClass {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();



            driver.get("https://www.google.com/");


            Actions actions = new Actions(driver);

            actions.keyDown(Keys.SHIFT).sendKeys("ibiza").keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).perform();













        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
