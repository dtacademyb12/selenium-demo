import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCaseAutomationWithAssertions {

    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
//        2. Navigate to google.com
        driver.get("https://www.google.com/");
//        3. Verify the url is "https://www.google.com/"

        String expectedUrl = "https://www.google.co";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        //Short version
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");


       // 4. Verify the title is "Google"

         Assert.assertEquals(driver.getTitle(),"Google");
//
//
        driver.quit(); // closes all open windows and ends the session




    }
}
