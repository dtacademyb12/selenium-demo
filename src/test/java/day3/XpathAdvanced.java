package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class XpathAdvanced {


    public static void main(String[] args) throws InterruptedException {


        //Predicate -> (//a[@data-ga-click='Repository, find file, location:repo overview'])[1]
        // Syntax (xpathExpression)[number]

        // Using attributes
        // //a[@role] -> all a elements that contain role attribute


        WebDriver driver = null ;
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait is a dynamic wait
            // that waits till the element is found
            driver.navigate().to("https://www.google.com/");


            // search for a term and verify each search results title contains the term
            String searchterm = "cisco";
            driver.findElement(By.xpath("//textarea[@jsname]")).sendKeys(searchterm, Keys.ENTER);

            List<WebElement> searchResultTitles = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));

            searchResultTitles.forEach(webElement -> System.out.println(webElement.getText()));
            searchResultTitles.forEach(webElement -> Assert.assertTrue(webElement.getText().toLowerCase().contains(searchterm)));

            // Click on the last result

            WebElement lastResult = searchResultTitles.get(searchResultTitles.size() - 1);

            lastResult.click();


//
        }finally {
            Thread.sleep(2000);
            driver.quit();
        }

    }
}
