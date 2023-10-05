import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FindingElements {


    public static void main(String[] args) throws InterruptedException {

      //TC-002





        WebDriver driver = new ChromeDriver();
        // Navigate to google.com
        driver.navigate().to("https://www.google.com/");

        // Search for "chatgpt"

//        WebElement seacrhBox = driver.findElement(By.name("q"));
//        seacrhBox.sendKeys("chatgpt");

        driver.findElement(By.name("q")).sendKeys("chatgpt", Keys.ENTER);


        // Verify the title contains "chatgpt"

        Assert.assertTrue( driver.getTitle().contains("chatgpt") );

        Thread.sleep(1000);

        driver.quit();

    }
}
