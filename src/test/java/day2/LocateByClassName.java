package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateByClassName {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;
        try{
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            System.out.println(driver.findElement(By.className("vector-tab-noicon")).getText());

            // Find element/s work by locating the first matching element on the page

            //InvalidSelectorException: Compound class names not permitted
            // By.className can use only a single class name but cannot be used with multiple classes such as 'vector-tab-noicon mw-list-item'


            List<WebElement> elements = driver.findElements(By.className("vector-tab-noicon"));

            for (WebElement element : elements) {
                System.out.println(element.getText());
            }




      } finally {
            Thread.sleep(2000);
             driver.quit();
        }


        }
}
