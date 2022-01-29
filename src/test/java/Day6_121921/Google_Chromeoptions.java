package Day6_121921;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Chromeoptions {
    public static void main(String[] args) throws InterruptedException {

        //set the property of the chromedriver we are using
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);

        //navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        System.out.println("navigated to google");

        //enter a keyword on google search
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        System.out.println("Entered keyword car on google search");



    }//end of main

}//end of java class
