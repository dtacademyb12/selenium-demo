package day5;

import day4.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class SwitchingWindows {


    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.toyota.com/");


            driver.findElement(By.xpath("//a[@aria-label='Toyota USA on Facebook']")).click();

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

//            driver.switchTo().window();

            // Switching using window handles with 2 windows
//            String toyotaWindowHandle = driver.getWindowHandle();//returns the current window's handle/id
//            System.out.println(toyotaWindowHandle);
//
//            Set<String> windowHandles = driver.getWindowHandles();// returns all open/active windows' handles in
//
//            System.out.println(windowHandles);
//
//            for (String windowHandle : windowHandles) {
//                if(!windowHandle.equals(toyotaWindowHandle)){
//                    driver.switchTo().window(windowHandle);
//                }
//            }

            SeleniumUtils.switchToWindow(driver, "Toyota USA | Facebook");

            driver.findElement(By.id(":rq:")).sendKeys("cdsgh@gmail.com");



        }finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
