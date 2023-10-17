package day4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Array;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.*;

public class PracticeWarmUp {

    public static void main(String[] args) throws InterruptedException {





        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.dice.com/");

            String searchTerm = "SDET";
            driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).
                    sendKeys(searchTerm);
            Thread.sleep(2000);
//        driver.findElement(By.id("IPGeoLocateButton")).click();
            driver.findElement(By.id("google-location-search")).sendKeys("Washington DC", Keys.ENTER);

            List<WebElement> titles = driver.findElements(By.xpath("//div[@id='searchDisplay-div']//a[@data-cy='card-title-link']"));

            Assert.assertEquals(titles.size(), 20);

            for (WebElement title : titles) {
//                System.out.println(title.getText());
                Assert.assertTrue(title.getText().toLowerCase().contains(searchTerm.toLowerCase()));

            }


            // Single job description
//            titles.get(0).click();
//
////            driver.findElement(By.id("descriptionToggle")).click();
//
//            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("descriptionToggle")));
//
//            // ElementClickInterceptedException:
//            // Happens when the element that you are clicking is covered by another element
//
//
//
//            String jobDescription = driver.findElement(By.xpath("//div[@id='jobDescription']//div[@*='jobDescriptionHtml']")).getText();


            String jobDescription = "";

//            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000);");
            for (int i = 0; i <titles.size(); i++) {

              try{
                  driver.findElements(By.xpath("//div[@id='searchDisplay-div']//a[@data-cy='card-title-link']")).get(i).click();

//                  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("descriptionToggle")));
//
//                  jobDescription += driver.findElement(By.xpath("//div[@id='jobDescription']//div[@*='jobDescriptionHtml']")).getText();
              }catch (Exception e){
                  System.out.println("Exception at " + i);
              }finally {
                  driver.navigate().back();
                  Thread.sleep(5000);
              }


            }



            System.out.println(jobDescription);

            // Find out the occurrence of each word

            String[] words = jobDescription.split("[ ,.():;\\n]");

            System.out.println(Arrays.toString(words));

            Map<String, Integer> map = new TreeMap<>();

            for (String word : words) {

                word = word.toLowerCase();
                if(!word.isBlank()){

                    if(!map.containsKey(word)){
                        map.put(word,1);
                    }else {
                        map.put(word, map.get(word)+1 );
                    }
                }

            }

            System.out.println(map);

            // Sort map by its values

            List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
//            Collections.sort(entries, Comparator.comparingInt(s -> s.getValue()) );
            Collections.sort(entries, Comparator.comparingInt(Map.Entry::getValue) );

            System.out.println(entries);


        }finally {
            Thread.sleep(3000);
            driver.quit();
        }


    }
}
