package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class XpathPractice2 {

    public static void main(String[] args) throws InterruptedException {

        /*

        Scenario: Movie Exploration, Review, and Watchlist Management on IMDb
Preconditions:
The tester has a valid IMDb account.
The tester is logged out of IMDb at the start.
Login:
Navigate to IMDb's homepage.
Click on the 'Sign In' link/button at the top right.
Enter valid credentials (email/username and password) and submit.
Validate that the user's profile icon or name appears at the top right, indicating a successful login.

Movie Search and Exploration:
        Use the search bar at the top to search for a specific movie or series, e.g., "The Shawshank Redemption".
        From the search results, click on the first result.
        Review the movie details, including the title, year, and user ratings.
Add Movie Review:
Scroll to the user review section of the movie page.
Click on the 'Write a Review' button/link.
Provide a star rating, a review title, and a brief review content (e.g., "Great movie! Loved the storyline and performances.").
Submit the review and ensure it gets posted (note: there might be a delay as reviews are sometimes moderated).
Manage Watchlist:
Navigate back to the movie's main page.
Click on the 'Add to Watchlist' button/link.
Validate that a confirmation message or icon change indicates the movie has been added to the watchlist.
Logout:
Click on the user's profile icon or name at the top right to access the account dropdown or profile menu.
Click 'Sign Out' or 'Logout'.
Validate the user has been logged out by ensuring the 'Sign In' link/button is present at the top right.


         */



//        Navigate to IMDb's homepage.
//        Click on the 'Sign In' link/button at the top right.
//        Enter valid credentials (email/username and password) and submit.
//        Validate that the user's profile icon or name appears at the top right, indicating a successful login.


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.imdb.com");

        driver.findElement(By.xpath("//span[.='Sign In']")).click();
        driver.findElement(By.xpath("//span[.='Sign in with IMDb']")).click();
        driver.findElement(By.xpath("//input[@maxlength='128']")).sendKeys("dtacademyb12@gmail.com");
        driver.findElement(By.xpath("//input[@maxlength='1024']")).sendKeys("duotech$2023");
        driver.findElement(By.xpath("//input[@type='submit'][@aria-labelledby='a-autoid-0-announce']")).click();


       WebElement userElement = driver.findElement(By.xpath("//label[@class='ipc-btn ipc-btn--single-padding ipc-btn--center-align-content ipc-btn--default-height ipc-btn--core-baseAlt ipc-btn--theme-baseAlt ipc-btn--on-textPrimary ipc-text-button navbar__flyout__text-button-after-mobile navbar__user-menu-toggle__button']"));


        Assert.assertTrue(userElement.isDisplayed());

        // Use the search bar at the top to search for a specific movie or series, e.g., "The Shawshank Redemption".
        //        From the search results, click on the first result.
        //        Review the movie details, including the title, year, and user ratings.




        String expectedTitle = "The Shawshank Redemption";
        driver.findElement(By.xpath("//div[@id='react-autowhatever-navSuggestionSearch']/preceding-sibling::input")).sendKeys(expectedTitle, Keys.ENTER);


        List<WebElement> elements = driver.findElements(By.xpath("//section[@data-testid='find-results-section-title']//a[@class='ipc-metadata-list-summary-item__t']"));

        elements.get(0).click();

        int year = 1994;
        System.out.println(driver.findElement(By.xpath("//h1[@data-testid='hero__pageTitle']//span")).getText());
        System.out.println(driver.findElement(By.xpath("(//a[@class='ipc-link ipc-link--baseAlt ipc-link--inherit-color'])[6]")).getText());

        System.out.println(driver.findElement(By.xpath("(//span[@class='sc-bde20123-1 iZlgcd'])[1]/parent::div")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@data-testid='hero__pageTitle']//span")).getText(), expectedTitle);
        Assert.assertEquals(driver.findElement(By.xpath("(//a[@class='ipc-link ipc-link--baseAlt ipc-link--inherit-color'])[6]")).getText(), year+"" );
        Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='sc-bde20123-1 iZlgcd'])[1]/parent::div")).getText().replace("\n", ""), "9.3/10" );

//        Thread.sleep(2000);
        driver.quit();

    }
}
