package demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    ChromeDriver driver = new ChromeDriver();
    public WindowHandle(){
        System.out.println("Constructor: WindowHandle");
        WebDriverManager.chromedriver().timeout(30).setup();        
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: WindowHandle");
        driver.close();
        driver.quit();

    }

    public  void Handle() throws InterruptedException{
           driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

            // Switch to the iframe containing the "Try it" button
            driver.switchTo().frame("iframeResult");

            // Locate and click the "Try it" button
            WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
            tryItButton.click();

            // Wait for the new window to open and switch to it
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
            }

            // Get URL and Title of the new window
            String newWindowUrl = driver.getCurrentUrl();
            String newWindowTitle = driver.getTitle();

            // Take a screenshot (you may need additional libraries for screenshot in Java)
            // For example, using TakesScreenshot
            // File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // FileUtils.copyFile(screenshot, new File("screenshot.png"));
            driver.getScreenshotAs(OutputType.FILE);

            // Close the new window
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(windowHandles.iterator().next());

            // Print results
            System.out.println("New Window URL: " + newWindowUrl);
            System.out.println("New Window Title: " + newWindowTitle);

    }
    
}
