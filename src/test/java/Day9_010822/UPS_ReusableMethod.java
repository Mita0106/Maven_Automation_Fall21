package Day9_010822;

import org.openqa.selenium.WebDriver;

public class UPS_ReusableMethod {
    public static void main(String[]args){

        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to ups
        driver.navigate().to("https://www.ups.com/us");

        //click on Track
        Reusable_Actions.clickMethod(driver,"//*[text()='Tracking']","Track");

        //click on track a package
        Reusable_Actions.clickMethod(driver,"//*[text()='Track a Package']","Track a Package");

        //enter any tracking number
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='stApp_trackingNumber']","111111111111111", "Enter Tracking");

        //click on Track button
        Reusable_Actions.clickMethod(driver,"//*[@id='stApp_btnTrack']","Track Button");

        //capture the error message and print out only 'We could not locate the shipment'
        String resultValue = Reusable_Actions.getTextMethod(driver,"//*[@id='stApp_error_alert_list0']","Error Message");
        //declare array and split
        String[] arrayResult = resultValue.split("details");
        System.out.println("My error info is " + arrayResult[0]);

    }//end of test

}//end of java class
