package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUpload2 {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://file.io/");

        // this requires using an absolute path
        String pathToThecurrentFolder = System.getProperty("user.dir");
        System.out.println(pathToThecurrentFolder);
        driver.findElement(By.id("upload-button")).sendKeys( pathToThecurrentFolder + "/src/test/java/day6/file.png");




        Thread.sleep(10000);
        driver.quit();


    }
}
