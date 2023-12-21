package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchAmazon {
    ChromeDriver driver;
    public SearchAmazon()
    {
        System.out.println("Constructor: SearchAmazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: SearchAmazon");
        driver.close();
        driver.quit();

    }

    
    public  void Search() throws InterruptedException{
        System.out.println("Start Test case: SearchAmazon");
        // driver.get("https://www.google.com");
       //Nevigate to google
        driver.get("https://www.google.com");

        //Enter text in google search
        WebElement searchbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Thread.sleep(2000);
        searchbox.sendKeys("Amazon");
        Thread.sleep(3000);
        //click on google search
        driver.findElement(By.xpath("//input[@class='gNO89b'][1]")).click();
        Thread.sleep(3000);
        // geeting text Amazon.in
       
        WebElement getresult =  driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
        System.out.println("Title of Amazon Page "+ getresult.getText());

    }


}
