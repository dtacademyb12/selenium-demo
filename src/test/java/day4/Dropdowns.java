package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdowns {


    public static void main(String[] args) throws InterruptedException {




        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

            driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,  "test", Keys.ENTER);

            driver.findElement(By.linkText("Order")).click();

//            driver.findElement(By.cssSelector("option[value=FamilyAlbum]")).click();


            // To interact with dropdowns Selenium uses Select class

            Select dropdownObject = new Select(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")));

            dropdownObject.selectByVisibleText("ScreenSaver");






        }finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }



}
