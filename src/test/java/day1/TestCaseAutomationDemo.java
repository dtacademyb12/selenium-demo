package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseAutomationDemo {

    public static void main(String[] args) {

        //TC-001. Google Search Functionality
        // Pre-requiste: Chrome should be installed
     /*
             Steps:
             1. Open a chrome browser
             2. Navigate to google.com
             3. Verify the url is "https://www.google.com/"
             4. Verify the title is "Google"
             5. Close the browser

             Expected Result: https://www.google.com/ and Google
             Actual Result: https://www.google.com/ and Google
             Status: PASS
      */


//        1. Open a chrome browser

        WebDriver driver = new ChromeDriver();
//        2. Navigate to google.com
        driver.get("https://www.google.com/");
//        3. Verify the url is "https://www.google.com/"
        if(driver.getCurrentUrl().equals("https://www.google.com/")){
            System.out.println("Url test PASSED");
        }else{
            System.out.println("FAIL");
        }
//        4. Verify the title is "Google"

        if(driver.getTitle().equals("Google")){
            System.out.println("Title test PASSED.");
        }else{
            System.out.println("FAIL");
        }


        driver.quit(); // closes all open windows and ends the session
        //driver.close(); // closes only the currently active window, if there are more windows they will stay active without closing



        // driver.get("dsd"); //NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

       //  NoSuchSessionException- happens when you try to use driver object by calling any method on it AFTER calling driver.quit()



    }
}
