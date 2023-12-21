package demo;

import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameText {
     ChromeDriver driver;
    public FrameText()
    {
        System.out.println("Constructor: FrameText");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: FrameText");
        driver.close();
        driver.quit();

    }

     public  void Text() throws InterruptedException{
        System.out.println("Start Test case: FrameText");
       //Nevigate to URL
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to top frame driver.switchTo().frame('frame-top')
        driver.switchTo().frame("frame-top");

        // // Switch to left frame driver.switchTo().frame('frame-left')
        driver.switchTo().frame("frame-left");

        // // Get LEFT text element and print text Using Locator "XPath" /html/body |
        // getText()
        String lft = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Left frame text: " + lft);

        // // Move back to parent frame /html/body | getText()
        driver.switchTo().parentFrame();

        // //Switch to middle frame driver.switchTo().frame('frame-middle')
        driver.switchTo().frame("frame-middle");

        // // Get MIDDLE text element and print text Using Locator "ID" id='content' |
        // getText()
        String middleTxt = driver.findElement(By.id("content")).getText();
        System.out.println("Middle frame text: " + middleTxt);

        // // Move back to parent frame driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();

        // // Switch to right frame driver.switchTo().frame('frame-right')
        driver.switchTo().frame("frame-right");

        // // Get RIGHT text element and print text Using Locator "XPath" /html/body |
        // getText()
        String rgtTxt = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Right frame text: " + rgtTxt);

        // // Move back to default frame driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();

        // Switch to bottom frame driver.switchTo().frame('frame-bottom')
        driver.switchTo().frame("frame-bottom");

        // Get BOTTOM text element and print text /html/body | getText()
        String btmTxt = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Bottom frame text: " + btmTxt);
      

    }
}
