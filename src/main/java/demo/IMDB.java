package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB {
     ChromeDriver driver;
    public IMDB() {
        System.out.println("Constructor: IMDB");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: IMDB");
        driver.close();
        driver.quit();

    }

    public  void ImdbRatings() throws InterruptedException{
                    // //Naviagte to Imdb
            // driver.get("https://www.imdb.com/chart/top");
            // //high rated movie
            // WebElement highrated =
            // driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3"));
            // //print highrated movie
            // System.out.println("Highest rated movie is " + highrated.getText());
            // //oldest movie

            driver.get("https://www.imdb.com/chart/top/");

            // driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
            // String oldestMovie = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3"))
            //         .getText();
            // System.out.println("2. Old Rated Movie  " + oldestMovie);

            //

            List<WebElement> movies = driver.findElements(By.xpath("//ul[@role='presentation']/li"));
            //print size
            
            System.out.println("The number of movies is "  + movies.size());
            Thread.sleep(3000);

            Select select = new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));
            select.selectByVisibleText("IMDb rating");
            Thread.sleep(2000);
            WebElement highestReatedMovie = driver.findElement(By.xpath("//*[text()='1. The Shawshank Redemption']"));
            System.out.println("Hiigh Rated Movie  " + highestReatedMovie.getText());
            Thread.sleep(3000);

            select.selectByVisibleText("Release date");
            Thread.sleep(2000);
            WebElement recentRattedMovie = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3"));
            System.out.println("Most recent Movie  " + recentRattedMovie.getText());
            Thread.sleep(3000);

            driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
            Thread.sleep(3000);
            WebElement oldestMovie = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3"));
            System.out.println("Old Rated Movie  " + oldestMovie.getText());
            Thread.sleep(3000);

            select.selectByVisibleText("Number of ratings");
            Thread.sleep(2000);
            WebElement mostRatedMovie = driver.findElement(By.xpath("//*[text()='1. The Shawshank Redemption']"));
            System.out.println(" Most user ratings  " + mostRatedMovie.getText());

    }
}
