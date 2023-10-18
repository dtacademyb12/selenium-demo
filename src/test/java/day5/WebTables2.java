package day5;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebTables2 {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.livecoinwatch.com/");

            // The number of columns
            // Get the header row td/ths into a list and get the size

           int columnCount = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//thead//th")).size();

           // The number of rows

           int rowCount =  driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']")).size();


           // Access each cell and perform some operation

          OUTER:  for (int i = 1; i <=rowCount ; i++) {

                for (int j = 1; j <=columnCount ; j++) {

                    String xpath = "//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row'][" + i + "]//td[" + j + "]";
//                    System.out.println(xpath);
//                    System.out.println(driver.findElement(By.xpath(xpath)).getText() + "\t");
                    if(driver.findElement(By.xpath(xpath)).getText().contains("Dogecoin")){
                        System.out.println(xpath);
                        WebElement element = driver.findElement(By.xpath(xpath + "//a"));
                        SeleniumUtils.jsClick(driver, element);
                        break OUTER;
                    }

                }
                System.out.println();

            }


        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
