package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CheckBoxes {


    public static void main(String[] args) throws InterruptedException {




        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

            driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,  "test", Keys.ENTER);

            driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click(); //check

            WebElement checkbox = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
            if(!checkbox.isSelected()){ // check if it is not selected already
                checkbox.click();
            }

            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));

            checkboxes.forEach(s ->
                    {
                         if (!s.isSelected())
                             s.click();
                    }
            );

            //Common issue with radio buttons and chcekboxes is ElementClickIntercepted or ElementNotInteractable exceptions
            // This is due to element being covered by another element, Solution: use JavascriptExecutor click


        }finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }



}
