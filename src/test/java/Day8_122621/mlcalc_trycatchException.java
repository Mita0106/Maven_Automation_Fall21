package Day8_122621;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mlcalc_trycatchException {
    public static void main(String[] args) throws InterruptedException {
        //call the webdrivermanager
        WebDriverManager.chromedriver().setup();
//call chromeoptions
        ChromeOptions options = new ChromeOptions();
//set incognito and maximize the driver
        options.addArguments("start-maximized");
//options.addArguments("incognito");
//set my webdriver
        WebDriver driver = new ChromeDriver(options);

//navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);

//enter value to purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        }catch (Exception e){
            System.out.println("unable to type value on Purchase price " + e);
        }//end of purchase price exception


//click on show advance action
        try{
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        }catch (Exception e){
            System.out.println("unable to click on Show advanced options " + e);
        }//end of Show advanced options exception

//select start month
        Thread.sleep(1000);
        try{
            WebElement sMonth =  driver.findElement(By.xpath("//*[@name='sm']"));
            Select sMonthDropdown = new Select(sMonth);
            sMonthDropdown.selectByVisibleText("Oct");
        }catch (Exception e){
            System.out.println("Unable to select value from start month list " + e);
        }//end of start month exception


    }//end of main


}//end of java class
