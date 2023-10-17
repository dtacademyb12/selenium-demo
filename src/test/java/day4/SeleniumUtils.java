package day4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {


    public static void jsClick(WebDriver driver, WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
}
