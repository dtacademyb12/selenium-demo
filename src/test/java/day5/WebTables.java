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
import java.util.Random;

public class WebTables {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

            driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,  "test", Keys.ENTER);


            // Verify row data
            List<String> expectedHeaders = List.of("Product name",	"Price", 	"Discount");

            driver.findElement(By.linkText("View all products")).click();
            List<WebElement> ths = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[1]//th"));

            List<String> actualHeaders = SeleniumUtils.getElementsText(ths);

            Assert.assertEquals(actualHeaders, expectedHeaders);

            // Verify column data
            List<String> expectedProducts = List.of("MyMoney",	"FamilyAlbum", 	"ScreenSaver");

            List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));
            //table[@class='ProductsTable']//tr//td[1]
            List<String> actualProducts = SeleniumUtils.getElementsText(elements);

            Assert.assertEquals(actualProducts, expectedProducts);

            //


        }finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
