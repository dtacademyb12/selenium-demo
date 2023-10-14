package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class XpathAdvanced2 {


    public static void main(String[] args) throws InterruptedException {




        // You can locate non-unique element through its unique parent
        //   syntax -> //parent//child
        //div[@class='a-cardui-header']//h2[@class='a-color-base headline']

        // You can locate non-unique element through its unique child
        //   syntax -> //tag[@attr='value']/parent::tag[@attr='value']
        //            //a[.='Disability Customer Support']/parent::div


        // You can locate non-unique element through its unique sibling that comes before it
        //   syntax -> //tag[@attr='value']/following-sibling::tag[1]
        //            //a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']/following-sibling::a

        // You can locate non-unique element through its unique sibling that comes after it
        //   syntax -> //tag[@attr='value']/preceding-sibling::tag[1]
        //           //a[@href='/prime?ref_=nav_cs_primelink_nonmember']/preceding-sibling::a[1]


        //How do you handle dynamic elements?
        // Dynamic element is an element with a dynamic attribute such as id, name

        //div[starts-with( @id, 'CardInstance')]
        //div[ends-with( @id, 'CardInstance')]
        //div[contains( @id, 'CardInstance')]

        WebDriver driver = null ;
        try {


            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait is a dynamic wait
            // that waits till the element is found
            driver.navigate().to("https://www.amazon.com/");


            System.out.println(driver.findElement(By.xpath("//div[@data-card-metrics-id='fluid-fat-image-link-v2_desktop-gateway-atf_1']//h2[@class='a-color-base headline truncate-2line']")).getText());
            System.out.println(driver.findElement(By.xpath("//a[.='Disability Customer Support']/parent::div")).getText());
            System.out.println(driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']/following-sibling::a")).getText());
            System.out.println(driver.findElement(By.xpath("//a[@href='/prime?ref_=nav_cs_primelink_nonmember']/preceding-sibling::a[1]")).getText());



            System.out.println(driver.findElement(By.xpath("//div[starts-with( @id, 'CardInstance')][@*='fluid-fat-image-link-v2_desktop-gateway-atf_1']")).getText());





//
        }finally {
            Thread.sleep(2000);
            driver.quit();
        }

    }
}
