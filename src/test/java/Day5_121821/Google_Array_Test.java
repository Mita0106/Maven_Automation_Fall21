package Day5_121821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Array_Test {
    public static void main(String[] args) throws InterruptedException {
        //search multiple cities and each time capture the search from the result page

        //set an array
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Staten Island";
        cities[3] = "Bronx";

        //define the webdriver outside of the for loop
        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver();

        for (int i=0; i < cities.length; i++){

            //simply open the google web site
            driver.navigate().to("https://www.google.com");

            //maximize my browser
            //driver.manage().window().fullscreen(); //for mac
            driver.manage().window().maximize(); //for windows

            //anytime when you go to a new page you should put some wait statement
            Thread.sleep(2000);

            //searching for cars on google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            //hit submit on google search button
            driver.findElement(By.xpath("//*[@value='Google Search']")).submit();

            //another wait statement since we came to a new page (result page)
            Thread.sleep(3000);

            //capture the search result and store it as a variable
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //declaring the array variable to split the result
            String[] arrayResult = result.split(" ");
            //now print the search number only
            System.out.println("My search number for city " + cities[i] + " is " + arrayResult[1]);



        }// end of for loop

        //quit will be defined outside of loop because you are quitting only once at the end
        driver.quit();





    }// end of main

}// end of java class

