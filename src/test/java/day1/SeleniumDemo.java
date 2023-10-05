package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        String title = driver.getTitle();

        System.out.println(title);

        String pageSource = driver.getPageSource();

        System.out.println("-------------------------");
        System.out.println(pageSource);
        System.out.println("-------------------------");

        if(pageSource.contains("Watch Now!")){
            System.out.println("Correct page");
        }else {
            System.out.println("Wrong page");
        }

    }
}
