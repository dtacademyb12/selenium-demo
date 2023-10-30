package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUpload {


    public static void main(String[] args) throws InterruptedException, AWTException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://open.spotify.com/");

        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();

        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("wiuterian2019@gmail.com", Keys.TAB, "sdet1234", Keys.ENTER);

        WebElement icon = driver.findElement(By.xpath("//div[@class='KdxlBanhDJjzmHfqhP0X Q4hOdDPRDHPhfou2xbDg m95Ymx847hCaxHjmyXKX']"));

        driver.findElement(By.xpath("//figure[@*='user-widget-avatar']")).click();
        driver.findElement(By.xpath("//a[@*='/user/31p5lcr3dkirlgo7kuqxqzpkjcvu']")).click();
        driver.findElement(By.xpath("//button[@*='edit-image-button']")).click();

        // write Robot class code to get rid of OS window


        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/duotech/IdeaProjects/selenium-demo2/src/test/java/day6/file.png");




        Thread.sleep(10000);
        driver.quit();


    }
}
