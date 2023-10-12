package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class XpathDemo {

    // Xpath ( XML Path  ) -> query language that is used to locate elements from XML/HTML files
    // In XPath you use a special expression that Xpath offers to locate elements

    public static void main(String[] args) throws InterruptedException {





        WebDriver driver = null;
        try{
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            driver.get("https://www.google.com/");

//            driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Hello");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys("Hello");




            //  Absolute Xpath -> /html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea

            // Relative XPath -> //textarea[@title='Search']


            //     //iframe -> matches all iframes on the page
            //     //a -> matches all links on the page

//            System.out.println(driver.findElement(By.xpath("//a")).getText());
//            driver.findElements(By.xpath("//a")).forEach(s -> System.out.println(s.getText()));

            System.out.println(driver.findElement(By.xpath("//a[@href='https://store.google.com/US?utm_source=hp_header&utm_medium=google_ooo&utm_campaign=GS100042&hl=en-US']")).getText());
            System.out.println(driver.findElement(By.xpath("//textarea[@id='APjFqb']")).getText());


            // You can use more than one attribute
            // //input[@class='gNO89b'][@value='Google Search']

//            driver.findElement(By.xpath("//input[@class='gNO89b'][@value='Google Search']")).click();


            // You can locate an element by its text

            //  //tag[.='text']
            //  //tag[ text()='tds' ]

            // Partial text
            //  //tag[ contains( text(), 'partOfText' ) ]

//            driver.findElement(By.xpath("//span[.='Our third decade of climate action: join us']")).click();
            driver.findElement(By.xpath("//span[ contains ( text(), 'join us') ]")).click();




        } finally {
            Thread.sleep(2000);
            driver.quit();
        }

    }
}
