package ActionItem3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bing {
    public static void main(String[] args) throws InterruptedException {
        //search different sports and capture the search for each sport

        //set an array
        String[] sports = new String[6];
        sports[0] = "Badminton";
        sports[1] = "Tennis";
        sports[2] = "Hockey";
        sports[3] = "Football";
        sports[4] = "Softball";
        sports[5] = "Soccer";

        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        options.addArguments("headless");

        //set the property of the chromedriver used
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define the web driver used
        WebDriver driver = new ChromeDriver();


        for (int i=0; i< sports.length; i++){


            //open the bing website
            driver.navigate().to("https://www.bing.com");

            //wait statement
            Thread.sleep(3000);

            //search for sports on bing search
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(sports[i]);

            //hit submit on search the web magnifying glass on bing
            driver.findElement(By.xpath("//*[@id= 'search_icon']")).submit();

            //wait statement
            Thread.sleep(3000);

            //capture search result and store it as a variable
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //declaring the array variable to split the result
            String[] arrayResult = result.split(" ");
            //Print search numbers only
            System.out.println("My search number for " + sports[i] + " is " + arrayResult[0]);


        }//end of for loop

        //defining quit outside for loop
        driver.quit();




    }//end of java

}//end of main
