package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
        // Navigate to the specified URL
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // Scroll down the whole page
        scrollPage(driver, 500);  // Adjust the scroll amount as needed

        // Scroll back to the top of the page
        scrollToTop(driver);
        // find the image
        List<WebElement> recommendedMoviesImages = driver.findElements(
                By.xpath("//h2[text() = 'Recommended Movies']/parent::div/parent::div/parent::div/parent::div//img"));
        // print Image URLS

        for (WebElement image : recommendedMoviesImages) {
            System.out.println(image.getAttribute("src"));
        }
        Thread.sleep(3000);

        // Print Name of the 2nd item in the Premiere list
        WebElement Pname = driver.findElement(By.xpath("//h2[text() = 'Premieres']/ancestor::div[@class='sc-133848s-4 kFcBGr']//a[2]//h3"));
                
                System.out.println("Name of the 2nd item in the Premiere list " + Pname.getText());
                Thread.sleep(3000);

        // Print Language of the 2nd item in the Premiere list
        WebElement Lname = driver.findElement(By.xpath("//h2[text() = 'Premieres']/ancestor::div[@class='sc-133848s-4 kFcBGr']//div[@class='sc-lnhrs7-0 ihaPEr']/div/div/a[2]//div[@class='sc-dv5ht7-0 fiAaps']/div[3]/div[2]/div"));
        System.out.println("Language of the 2nd item in the Premiere list " + Lname.getText());

    }

        private static void scrollPage(WebDriver driver, int scrollAmount) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            long initialHeight;
            long currentHeight = (long) js.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
    
            do {
                initialHeight = currentHeight;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    
                try {
                    Thread.sleep(1000); // Adjust sleep time based on your preference
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                currentHeight = (long) js.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
    
            } while (currentHeight > initialHeight);
    }

    private static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }


}
