package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass3 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();



            driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");


            Actions actions = new Actions(driver);
            actions.contextClick(driver.findElement(By.xpath("//span[.='right click me']")))
                    .sendKeys(Keys.ARROW_DOWN) .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();













        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
