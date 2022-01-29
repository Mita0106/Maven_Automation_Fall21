package ActionItem4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class WeightWatchers {

    public static void main(String[] args) throws InterruptedException {

        //call the webdrivermanager
        WebDriverManager.chromedriver().setup();
        //call chromeoptions
        ChromeOptions options = new ChromeOptions();
        //maximize driver and set to incognito mode

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //set webdriver
        WebDriver driver = new ChromeDriver(options);

        //Array list
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11365");
        zipcode.add("11373");
        zipcode.add("11103");

        for (int i=0; i < zipcode.size(); i ++) {

            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            //click on attend dropdown,
            try {
                WebElement attend = driver.findElement(By.xpath("//*[@data-e2e-name= 'attend']"));
                attend.click();
            } catch (Exception e) {
                System.out.println("Unable to click on attend " + e);
            }//end of attend exception

            //click on Unlimited Workshop
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on unlimited workshop " + e);
            }//end of unlimited workshop exception

            Thread.sleep(2000);

            //click on studio
            try {
                WebElement studio = driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']"));
                studio.click();
            } catch (Exception e) {
                System.out.println("unable to click studio " + e);
            }//end of studio link exception

            //enter the zipcode
            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipcode.get(i));
            }catch (Exception e) {
                System.out.println("unable to enter zipcode " + zipcode.get(i) + e);
            }// end of entering zipcode exception

            //click on search arrow
            try {
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            }catch (Exception e){
                System.out.println("unable to click arrow " + e);
            }//end of search click exception
            Thread.sleep(2000);

            //click on specific link for the studios
            try {
                List<WebElement>studioLoc=driver.findElements(By.xpath("//*[contains(text(),'WW Studio')]"));
                if (i==0){
                    studioLoc.get(2).click();
                }
                if (i==1){
                    studioLoc.get(3).click();
                }
                if (i==2){
                    studioLoc.get(1).click();
                }
            }catch (Exception e){
                System.out.println("unable to click on studio link " + e);
            }//end of click on specific link for studios exception

            Thread.sleep(2000);

            //capture the entire address and print the address
            try {
                String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("For zip code " + zipcode.get(i) + "the address is " + address);
            }catch (Exception e){
                System.out.println("Unable to capture and print address " + e);
            }//end of capture and print exception

            //scroll to the schedule
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            try {
                jse.executeScript("scroll(0,1200)");
            }catch (Exception e){
                System.out.println("unable to scroll " + e);
            }//end of scroll

            //Print virtual schedule table
            try {
                String virtualschedule = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']")).getText();
                System.out.println("For this location the virtual schedule is " + virtualschedule);
            }catch (Exception e){
                System.out.println("unable to print schedule " + e);
            }//end of printing exception


        }//end of for loop

        //quit outside loop
        driver.quit();

    } //end of main

}//end of java class
