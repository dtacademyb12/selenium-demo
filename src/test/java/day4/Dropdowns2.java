package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Dropdowns2 {


    public static void main(String[] args) throws InterruptedException {




        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.cargurus.com/");


            driver.findElement(By.xpath("//span[.='Buy Used']")).click();

            WebElement selectWebelement = driver.findElement(By.id("carPickerUsed_makerSelect"));

            Select select = new Select(selectWebelement);

            select.selectByVisibleText("Tesla");
//            select.selectByIndex(2);  // zero-based index

          Select modelDropdown =  new Select(driver.findElement(By.cssSelector("#carPickerUsed_modelSelect")));

          List<String> expectedModelsForTesla = List.of("All Models",
                  "Model 3",
                  "Model S",
                  "Model X",
                  "Model Y",
                  "Roadster");

            List<WebElement> allOptions = modelDropdown.getOptions();

//            List<String> actualOptionsForTesla = new ArrayList<>();
//            for (WebElement allOption : allOptions) {
//                actualOptionsForTesla.add(allOption.getText());
//            }

            List<String> actualOptions = SeleniumUtils.getElementsText(allOptions);

            Assert.assertEquals(actualOptions, expectedModelsForTesla);



            // To grab the default dselected option

            WebElement firstSelectedOption = modelDropdown.getFirstSelectedOption();

            Assert.assertEquals(firstSelectedOption.getText(), "All Models");


//            driver.findElement(By.name("zip")).sendKeys("22152", Keys.ENTER);

        }finally {
            Thread.sleep(4000);
            driver.quit();
        }
    }



}
