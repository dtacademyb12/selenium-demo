package day4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RadioButtons {


    public static void main(String[] args) throws InterruptedException {




        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

            driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,  "test", Keys.ENTER);



            driver.findElement(By.linkText("Order")).click();

            List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

            // Click on random radio button

//            radioButtons.get(new Random().nextInt(3)).click();
            WebElement radioButton = radioButtons.get(new Random().nextInt(3));
//            radioButton.click();

//            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", radioButton);

            SeleniumUtils.jsClick(driver, radioButton);


        }finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }



}
