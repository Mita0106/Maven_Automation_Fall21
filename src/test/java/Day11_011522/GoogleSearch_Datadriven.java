package Day11_011522;

import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Annotations;
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

public class GoogleSearch_Datadriven extends Reusable_Annotations {

    @Test
    public void GoogleSearchDataDriven() throws IOException, BiffException, WriteException {
        //Step 1: read the data from the excel sheet you created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/GoogleSearch.xls"));
        //Step 2: locating the worksheet that you created for the workbook
        Sheet readableSheet = readableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount = readableSheet.getRows();
        //System.out.println("My row count is " + rowCount);

        //Step 3: create a writable file to mimic readable but you can also write back the results to this file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/GoogleSearch_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount2 = writableSheet.getRows();
        //System.out.println("My writable row count is " + rowCount2);

        //generate the for/while loop
        int i = 1;
        while (i < rowCount2) {

            //store the countries list as a variable
            String countries = writableSheet.getCell(0, i).getContents();
            System.out.println("My values are " + countries);

            //navigate to google
            driver.navigate().to("https://www.google.com");
            //enter countries on my google search field
            Reusable_Actions.sendKeysMethod(driver, "//*[@name='q']", countries, "Search Field");
            //submit to google search button
            Reusable_Actions.submitMethod(driver, "//*[@name='btnK']", "Google Search Button");

            //capture the result
            String results = Reusable_Actions.getTextMethod(driver, "//*[@id='result-stats']", "Search Rsult");
            String[] arrayResults = results.split(" ");

            //Step 5: storing the values to the writable excel sheet
            Label label = new Label(1, i, arrayResults[1]);
            //I need to write back to the writable sheet
            writableSheet.addCell(label);

            //increment
            i = i + 1;
        }//end of loop

        //Step 6: writing back to the writable file to see
        writableFile.write();
        writableFile.close();

    }//end of test




}
