package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass4 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();



            driver.get("https://javascript.info/mouse-drag-and-drop");



            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/article/mouse-drag-and-drop/ball4/']")));
            Actions actions = new Actions(driver);

            WebElement ball = driver.findElement(By.id("ball"));
            WebElement gate = driver.findElement(By.id("gate"));

            actions.dragAndDrop(ball, gate).perform();











        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
