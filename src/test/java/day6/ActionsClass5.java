package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass5 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();



            driver.get("https://javascript.info/mouse-drag-and-drop");



            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://en.js.cx/article/mouse-drag-and-drop/ball3/']")));
            Actions actions = new Actions(driver);

            WebElement ball = driver.findElement(By.id("ball"));

//            actions.dragAndDropBy(ball, 500, 0).perform();
            actions.clickAndHold(ball).moveByOffset(500,0).release(ball).perform();


            driver.get("https://www.amazon.com/");

            WebElement arrow = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

            actions.moveToElement(arrow).click(driver.findElement(By.xpath("//a[@href='/gp/css/homepage.html?ref_=nav_AccountFlyout_ya']"))).perform();

        }finally {
//            Thread.sleep(10000);
//            driver.quit();
        }


    }
}
