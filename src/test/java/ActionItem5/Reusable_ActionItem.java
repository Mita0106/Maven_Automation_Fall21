package ActionItem5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Reusable_ActionItem {

    //create a reusable method for javascript executor for scrolling by pixels
    public static void scrollMethod(WebDriver driver, String x, String y){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll("+x+","+y+")");

    }//end of scroll method



}
