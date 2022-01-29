package USPS_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Homepage extends Reusable_Annotations {

    //constructor is helper method that allows you to identify objects in your pom
    //so later you can class those methods in your test class
    //because your pom class is not static
    //declare a local logger to your pom class
    ExtentTest logger;
    public Homepage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//li[contains(@class,'menuheader')]")
    List<WebElement> navigationTabsList;
    @FindBy(xpath = "//*[@id='mail-ship-width']")
    WebElement SendTab;


    //create a pom method to get the link count for the list
    public void getNavigationTabsCount(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(navigationTabsList));
            logger.log(LogStatus.PASS,"Successfully located the navigation tabs count " + navigationTabsList.size());
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to get count from Navigation tabs " + e);
        }
    }//end of method 1

    public void clickOndSendTab(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,SendTab,logger,"Send Tab");
    }//end of clicking on ship tab






}
