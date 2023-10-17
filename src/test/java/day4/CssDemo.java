package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssDemo {

    public static void main(String[] args) throws InterruptedException {





        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.dice.com/");

            // locate an input element with a class
            // input.form-control

            // locate an input element with an id
            // input#typeaheadInput

            // locate an element by its attribute
            // input[data-cy='typeahead-input']
           // input[data-cy='typeahead-input'][autocomplete='off']

//            driver.findElement(By.cssSelector("input.form-control")).sendKeys("bcd svgdsv");
//            driver.findElement(By.cssSelector("input#typeaheadInput")).sendKeys("bcd svgdsv");
//            driver.findElement(By.cssSelector("#typeaheadInput")).sendKeys("bcd svgdsv");
            driver.findElement(By.cssSelector("input[data-cy='typeahead-input']")).sendKeys("bcd svgdsv");

            // Finding dynamic elements

            // starts with ->  ^= ->  div[id^='dismissableComponent-']
            // ends with ->  $= ->  div[id$='dismissableComponent-']
            // contains  ->  *= ->  div[id*='dismissableComponent-']

            System.out.println(driver.findElement(By.cssSelector("div[id^='dismissableComponent-']")).getText());




        }finally {
            Thread.sleep(3000);
            driver.quit();
        }


    }
}
