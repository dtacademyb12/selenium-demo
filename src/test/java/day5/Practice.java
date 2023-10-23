package day5;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Practice {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            driver.get("https://www.tripadvisor.com/");

            driver.findElement(By.name("q")).sendKeys("Paris", Keys.ENTER);

            driver.findElement(By.xpath("//div[@class='location-meta-block']//span[.='Paris']")).click();

            SeleniumUtils.switchToWindow(driver, "Paris, France 2023: Best Places to Visit - Tripadvisor");

            driver.findElement(By.xpath("(//div[@class='IvGkt hnsQj pTcNu BhqVp GRfiG jdaPs']//a[@href='/Hotels-g187147-Paris_Ile_de_France-Hotels.html'])[1]")).click();


            driver.findElement(By.xpath("(//div[@class='tuqBW' and .='23'])[1]")).click();
            driver.findElement(By.xpath("(//div[@class='tuqBW' and .='27'])[1]")).click();
            driver.findElement(By.xpath("//button[@data-automation='guestsUpdateBtn']")).click();

            driver.findElement(By.xpath("//button[@aria-label='BEST_VALUE: Best Value']")).click();
            driver.findElement(By.id("menu-item-PRICE_LOW_TO_HIGH")).click();

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='yJIls z y M0' and not ( .//span[.='Sponsored'] ) ]//div[@class='BVksS']//span[@class='fwoto f']"));

            List<Integer> prices = new ArrayList<>();
            for (WebElement element : elements) {
                prices.add(Integer.parseInt(element.getText().replace("$", "")));
            }

            // To check if the list is sorted
            // Create a copy and sort the copy and compare with the original

            List<Integer> copy = new ArrayList<>(prices);

            Collections.sort(copy);
            System.out.println("Original" + prices);
            System.out.println("Copy" + copy);

            Assert.assertEquals(prices, copy);





        }finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
