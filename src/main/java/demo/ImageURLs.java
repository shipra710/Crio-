package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageURLs {

    ChromeDriver driver;

    public ImageURLs() {
        System.out.println("Constructor: ImageURLs");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: ImageURLs");
        driver.close();
        driver.quit();

    }

    public void Img() throws InterruptedException {
        // Nevigate the URL
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find the image
        js.executeScript("window.scrollBy(0, 800)");
        List<WebElement> recommendedMoviesImages = driver.findElements(
                By.xpath("//h2[text() = 'Recommended Movies']/parent::div/parent::div/parent::div/parent::div//img"));
        // print Image URLS

        for (WebElement image : recommendedMoviesImages) {
            System.out.println(image.getAttribute("src"));
        }
        Thread.sleep(3000);

         
      
      
    //   js.executeScript("window.scrollBy(0, 500)");

        // Print Name of the 2nd item in the Premiere list
        WebElement Pname = driver.findElement(By.xpath("//h2[text() = 'Premieres']/ancestor::div[@class='sc-133848s-4 kFcBGr']//a[2]//h3"));
                
                System.out.println("Name of the 2nd item in the Premiere list " + Pname.getText());
                Thread.sleep(3000);

        // Print Language of the 2nd item in the Premiere list
        WebElement Lname = driver.findElement(By.xpath("//h2[text() = 'Premieres']/ancestor::div[@class='sc-133848s-4 kFcBGr']//div[@class='sc-lnhrs7-0 ihaPEr']/div/div/a[2]//div[@class='sc-dv5ht7-0 fiAaps']/div[3]/div[2]/div"));
        System.out.println("Language of the 2nd item in the Premiere list " + Lname.getText());

    }

}
