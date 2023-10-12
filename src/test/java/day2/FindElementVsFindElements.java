package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class FindElementVsFindElements {

    public static void main(String[] args) throws InterruptedException {




        WebDriver driver = null;
        try{
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            driver.get("https://en.wikipedia.org/wiki/Main_Page");

//            System.out.println(driver.findElement(By.tagName("iframe")).getText());
//            System.out.println(driver.findElement(By.id("someID")).getText());

            // when findElement method can't find the element
            // NoSuchElementException is thrown

            List<WebElement> list = driver.findElements(By.className("hello"));

            if(list.isEmpty()){
                throw  new RuntimeException("No elements found");
            }

            for (WebElement webElement : list) {
                Assert.assertTrue(webElement.isDisplayed());
            }


            // when findElements method can't find the element
            // no exception is thrown but an empty list is returned






        } finally {
            Thread.sleep(2000);
            driver.quit();
        }




    }
}
