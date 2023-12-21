package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PostOnLinkedIn {
     ChromeDriver driver;
    public PostOnLinkedIn()
    {
        System.out.println("Constructor: PostOnLinkedIn");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: PostOnLinkedIn");
        driver.close();
        driver.quit();

    }

    public void Post_on_linkedin() throws InterruptedException {
        // Navigate to LinkedIn
        
        // Enter UserName in username text box
        WebElement username = driver.findElement(By.id("session_key"));
        username.sendKeys("goyalshipra710@gmail.com");
        // Enter Password in password text box
        WebElement pass = driver.findElement(By.id("session_password"));
        pass.sendKeys("13071996");
        // Click on signin button
        WebElement signbutton = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]"));
        signbutton.click();
        Thread.sleep(5000);
        // Locate profile viewers and get count  Using Locator "XPath" //ul[@class='entity-list row']//child::li[1]//child::a//child::div//child::div[2] /.getText()
        WebElement profileveiw = driver.findElement(By.xpath("//a[@href='/me/profile-views/']"));
        profileveiw.click();
        WebElement viewedcount = driver.findElement(By.xpath("//p[contains(@class,'medium-bold pr1')]"));
        String viw = viewedcount.getText();
        System.out.println(viw);
        driver. navigate(). back();

            // Locate post impressions and get count Using Locator "XPath" //ul[@class='entity-list row']//child::li[2]//child::a//child::div//child::div[2] / .getText()
            WebElement impbtn = driver.findElement(By.xpath("//a[@href='/dashboard/']"));
            impbtn.click();
            WebElement impression = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/analytics/creator/content?timeRange=past_7_days&dimension=INDUSTRY&metricType=IMPRESSIONS']"));
            String imp =impression.getText();
            // Print post impressions  
            System.out.println(imp);
            // Click on button to sharing with 'Connections only' Using Locator "XPath"
            driver. navigate(). back();
            WebElement startpostbtn = driver.findElement(By.xpath("//span[text()='Start a post']"));
            startpostbtn.click();
            driver.findElement(By.className("relative artdeco-entity-lockup artdeco-entity-lockup--size-4 ember-view")).click();
            // Click on connections only button Using Locator "ID" CONNECTIONS_ONLY
            // Click on Done button Using Locator "XPath" //span[text()='Done']
            driver.findElement(By.id("CONNECTIONS_ONLY")).click();
            driver.findElement(By.xpath("//span[text()='Done']")).click();

            // Enter text on text box Using Locator "Class" Name editor-container relative/sendKeys("CRIO Masters in QA automation")
            WebElement postcontent = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
            postcontent.sendKeys("Success is not how high you have climbed, but how you make a positive difference to the world.");
            // Click on post button Using Locator "Class" Name share-box_actions
            WebElement post = driver.findElement(By.xpath("//button[contains(@class,'share-actions__primary-action')]"));
            post.click();


    }

    }

    

