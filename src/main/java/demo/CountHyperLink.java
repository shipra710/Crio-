package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperLink {

    ChromeDriver driver;
    public CountHyperLink()
    {
        System.out.println("Constructor: CountHyperLink");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void count() throws InterruptedException{
        System.out.println("Start Test case: CountHyperLink");
        // driver.get("https://www.google.com");
       //Nevigate to BookmyShow
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //Using tagname with anchor
         List<WebElement> links = driver.findElements(By.tagName("a"));
         //print size
         
         System.out.println("The number of links is "  + links.size());
    }

    
    
}
