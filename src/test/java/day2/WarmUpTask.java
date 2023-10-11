package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WarmUpTask {


    /*
    TEST CASE: Content Exploration on Wikipedia
Preconditions:
• The tester has a valid Wikipedia account.
• The tester is logged out of Wikipedia at the start.
1.  Login:
• Navigate to Wikipedia's homepage.
• Click on the 'Login' link at the top right.
• Enter valid credentials (username and password).
• Click the 'Login' button.
• Validate that the user's username appears at the top right, indicating a successful login.
2.  Search and Content Exploration:
• Use the main search bar to search for a specific term, e.g., "Galileo Galilei".
• Verify that the search term appears on top as a header.
3.  Logout:
• Click on the username at the top right to access the dropdown menu.
• Click 'Logout'.
• Validate the user is logged out by ensuring the 'Login' link is present at the top right.
     */


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;
       try{
           driver = new ChromeDriver();

           //maximize window
           driver.manage().window().maximize();

           driver.get("https://en.wikipedia.org/wiki/Main_Page");

           driver.findElement(By.linkText("Log in")).click();

           String expectedUsername = "Duotech2023";
           driver.findElement(By.name("wpName")).sendKeys(expectedUsername, Keys.TAB, "duotech$2023", Keys.ENTER );
//        driver.findElement(By.name("wpPassword")).sendKeys("duotech$2023");
//        driver.findElement(By.name("wploginattempt")).click();

           String actualUsername = driver.findElement(By.linkText(expectedUsername)).getText();
           Assert.assertEquals(actualUsername, expectedUsername);

           String expectedSearchTerm = "Galileo Galilei";
           driver.findElement(By.name("search")).sendKeys(expectedSearchTerm, Keys.ENTER);

           //ElementNotInteractableException: element not interactable
           // happens when element is on the HTML code but not visible to the user

           String actualSearchTerm = driver.findElement(By.id("firstHeading")).getText();

           Assert.assertEquals(actualSearchTerm, expectedSearchTerm);

           driver.findElement(By.id("vector-user-links-dropdown-checkbox")).click();
           Thread.sleep(500);
           driver.findElement(By.linkText("Log out")).click();

           WebElement logOutHeader = driver.findElement(By.id("firstHeading"));

           Assert.assertTrue(logOutHeader.isDisplayed());
       } finally {
           driver.quit();
       }




    }
}
