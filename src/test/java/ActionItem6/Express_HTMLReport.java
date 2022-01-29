package ActionItem6;

import ActionItem5.Reusable_ActionItem;
import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_HTMLReport {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/ExpressReport.html", true);
    }//end of precondition

    @Test
    public void ExpressOrder() throws InterruptedException, BiffException, IOException, WriteException {
        //read the data from the excel sheet
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/ExpressExcel2.xls"));
        //locate the worksheet
        Sheet readableSheet = readableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount = readableSheet.getRows();

        //create a writable file so we can write back
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressExcel_results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount2 = writableSheet.getRows();

        logger = reports.startTest("Order on Express");

        for(int i = 1; i < rowCount2; i++) {

            //store each excel column as a variable
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String FirstName = writableSheet.getCell(2, i).getContents();
            String LastName = writableSheet.getCell(3, i).getContents();
            String Email = writableSheet.getCell(4, i).getContents();
            String PhoneNumber = writableSheet.getCell(5, i).getContents();
            String Address = writableSheet.getCell(6, i).getContents();
            String ZipCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CardNumber = writableSheet.getCell(10, i).getContents();
            String ExpMonth = writableSheet.getCell(11, i).getContents();
            String ExpYear = writableSheet.getCell(12, i).getContents();
            String CVV = writableSheet.getCell(13, i).getContents();


            //navigate to express website
            logger.log(LogStatus.INFO, "Navigate to express home page");
            driver.navigate().to("https://www.express.com");

            //verify we're on page titled 'Men's and Women's Clothing'
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Men's & Women's Clothing")) {
                System.out.println("Title contains Men's & Women's Clothing");
            } else {
                System.out.println("Title doesn't contain the words Men's & Women's Clothing");
            }//end of if statement

            //hover to the women's tab
            Reusable_Actions_Loggers.mouseHover(driver, "//*[contains(@href,'/womens-clothing?')]", logger, "Women's Tab");

            //click on dresses link
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Dresses']", logger, "Dresses");
            Thread.sleep(3000);

            //scroll 400-500 pixels
            Reusable_ActionItem.scrollMethod(driver, "0", "500");

            Reusable_Actions_Loggers.clickMethodpopup(driver,"//*[@name='bluecoreCloseButton']",logger);



            //click on second image
            Reusable_Actions_Loggers.ClickByIndex(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']", 1, logger, "2nd dress");
            Thread.sleep(3000);

            //click on specific size
            Reusable_Actions_Loggers.clickMethod(driver, "//button[@value='"+Size+"']",logger, "Size");

            //click on add to bag
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Add to Bag']",logger,"Add to bag");

            //click on view bag
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='View Bag']",logger,"View Bag");
            Thread.sleep(2000);

            //select different quantity
            Reusable_Actions_Loggers.selectMethod(driver,""+Quantity+"","//*[@id='qdd-0-quantity']",logger, "Quantity");

            //click on checkout
            Reusable_Actions_Loggers.clickMethod(driver,"//*[@id='continue-to-checkout']", logger, "Checkout");

            //click checkout as guest
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Checkout as Guest']", logger, "Guest Checkout");
            Thread.sleep(2000);

            //Enter first name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='firstname']",""+FirstName+"", logger, "First name");

            //Enter last name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='lastname']",""+LastName+"", logger, "Last name");

            //Enter Email
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='email']",""+Email+"", logger, "Email");

            //Re-enter same email
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='confirmEmail']",""+Email+"", logger, "Re-enter Email");

            //enter phone number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='phone']",""+PhoneNumber+"", logger, "Phone Number");

            //click on continue button
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']", logger, "Continue");

            //Enter street addresss
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.line1']",""+Address+"", logger, "Street Address");

            //Enter Zip Cde
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.postalCode']",""+ZipCode+"", logger, "Zip Code");

            //Enter City
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.city']",""+City+"", logger, "City");

            //Select State
            Reusable_Actions_Loggers.selectMethod(driver, ""+State+"", "//*[@name='shipping.state']", logger,"State");

            //click on continue
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']", logger, "Continue " );
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']", logger, "Continue " );

            //Enter card number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='creditCardNumber']",""+CardNumber+"", logger, "Card Number");

            //select expiration Month
            Reusable_Actions_Loggers.selectMethod(driver, ""+ExpMonth+"", "//*[@name='expMonth']", logger, "Expiration Month");

            //select expiration year
            Reusable_Actions_Loggers.selectMethod(driver, ""+ExpYear+"", "//*[@name='expYear']", logger, "Expiration Year");

            //Enter CVV
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='cvv']",""+CVV+"", logger, "CVV Number");

            //click place order
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Place Order']", logger, "Place Order" );

            //capture error message and send back to excel
            String results = Reusable_Actions.getTextMethod(driver,"//*[@id='rvn-note-NaN']","Error Message");


            //store values to writable excel
            Label label = new Label(14, i, results);

            //write to writable sheet
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();

        }//end of for loop

        //writing back to the writable file to see
        writableFile.write();
        writableFile.close();

        //end the logger
        reports.endTest(logger);

    }//end of test
    @AfterSuite
    public void endTest(){
        driver.quit();
        //write/log the informations back to the html report
        reports.flush();
    }//end of after suite

}//end of java class
