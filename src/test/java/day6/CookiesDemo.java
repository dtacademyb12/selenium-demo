package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class CookiesDemo {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


            driver.get("https://www.amazon.com/");


            Set<Cookie> cookies = driver.manage().getCookies();

            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }

            driver.manage().deleteAllCookies();

            driver.manage().getCookies().forEach( s -> System.out.println(s));



        }finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }
}
