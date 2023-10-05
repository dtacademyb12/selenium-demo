package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().to("https://www.duotech.io/");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();

    }
}
