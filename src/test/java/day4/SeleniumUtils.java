package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {


    public static void jsClick(WebDriver driver, WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public static List<String> getElementsText(List<WebElement> list){

        List<String> actualList = new ArrayList<>();
        for (WebElement allOption : list) {
            actualList.add(allOption.getText());
        }

        return actualList;
    }


    public static void switchToWindow(WebDriver driver, String title){

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(title)){
                break;
            }
        }
    }


    public static void waitTillElementIsPresent(WebDriver driver, By by, int timeout){
       new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
