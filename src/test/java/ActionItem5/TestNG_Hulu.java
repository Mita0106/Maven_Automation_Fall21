package ActionItem5;

import Day9_010822.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import javax.naming.Name;
import java.util.ArrayList;

public class TestNG_Hulu {
    //declare the webdriver outside of the annotation methods so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test(priority = 1)
    public void huluSearchLoop() {
        ArrayList<String> Email = new ArrayList<>();
        Email.add("msskik10@gmail.com");
        Email.add("msskik11@gmail.com");

        ArrayList<String> Password = new ArrayList<>();
        Password.add("makingsure");
        Password.add("makingsure");

        ArrayList<String> Name = new ArrayList<>();
        Name.add("Katy Adams");
        Name.add("Bob Mob");

        ArrayList<String> Month = new ArrayList<>();
        Month.add("January");
        Month.add("February");

        ArrayList<String> Date = new ArrayList<>();
        Date.add("6");
        Date.add("19");

        ArrayList<String> Year= new ArrayList<>();
        Year.add("1992");
        Year.add("1990");

        ArrayList<String> Gender = new ArrayList<>();
        Gender.add("Male");
        Gender.add("Female");


        for(int i = 0; i < Email.size(); i++){
            //navigating to Hulu
            driver.navigate().to("https://www.hulu.com");
            //verify the title says "Stream TV and Movies"
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Stream TV and Movies")){
                System.out.println("Title matches Stream TV and Movies");
            }else {
                System.out.println("Title doesn't match, actual title is " + actualTitle);
            }

            //scroll to the bottom of page using pixel
            Reusable_ActionItem.scrollMethod(driver,"0", "3500");

            //click on select button
            Reusable_Actions.clickMethod(driver,"//*[@class='button--cta button--black plan-card__cta plan-card__0_cta button--black ']","Select Button");

            //enter email address from array list
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='email']", (Email.get(i)),"Email");

            //enter password from array list
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='password']", (Password.get(i)),"Password");

            //enter name from array list
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='firstName']", (Name.get(i)),"Name");

            //Select birth month
            Reusable_Actions.clickMethod(driver,"//*[@class='selector-selected input__text placeholder']","Month");
            Reusable_Actions.clickMethod(driver,"//*[text()= '"+(Month.get(i))+"']","Month");

            //Select birth date
            Reusable_Actions.clickMethod(driver,"//*[@class='selector-selected input__text placeholder']","Day");
            Reusable_Actions.clickMethod(driver,"//*[text()='"+(Date.get(i))+"']","Day");

            //Select birth year
            Reusable_Actions.clickMethod(driver,"//*[@class='selector-selected input__text placeholder']","Year");
            Reusable_Actions.clickMethod(driver,"//*[text()='"+(Year.get(i))+"']","Year");

            //Select Gender
            Reusable_Actions.clickMethod(driver,"//*[@class='selector-selected input__text placeholder']","Gender");
            Reusable_Actions.clickMethod(driver,"//*[text()='"+(Gender.get(i))+"']","Gender");

            //click continue
            Reusable_Actions.clickMethod(driver,"//*[contains(@class,'button button--continue')]","Continue");

            //capture subscription amount and store as string value and print
            String SubscriptionAmount = Reusable_Actions.getTextMethod(driver,"//*[@class='ledger__item']","Subscription amount");
            System.out.println("My subscription amount is " +SubscriptionAmount);

            //capture total due today is $0 and store as string value and print
            String AmountDueToday = Reusable_Actions.getTextMethod(driver,"//*[@class='ledger__summary']","Amount Due today");
            System.out.println("My amount due today is " +AmountDueToday);

            driver.manage().deleteAllCookies();

        }//end of for loop

    }//end of test 1

    @Test(priority = 2)
    public void HuluLogin(){

        ArrayList<String> Email = new ArrayList<>();
        Email.add("msskik10@gmail.com");
        Email.add("msskik11@gmail.com");

        ArrayList<String> Password = new ArrayList<>();
        Password.add("makingsure");
        Password.add("makingsure");

        ArrayList<String> Name = new ArrayList<>();
        Name.add("Katy Adams");
        Name.add("Bob Mob");


        //navigating to Hulu
        driver.navigate().to("https://www.hulu.com");

        //click on login
        Reusable_Actions.clickMethod(driver,"//*[@class='navigation__login-button navigation__action-button navigation__cta']","Log in");

        //enter email
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='email_id']",(Email.get(0)),"Email");

        //enter password
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='password_id']",(Password.get(0)),"Password");

        //click on login button
        Reusable_Actions.clickMethod(driver, "//*[@class='jsx-4282396490 button-dark login-button']","Login");

        //click on the name registered to hulu
        Reusable_Actions.clickMethod(driver,"//*[text()='"+(Name.get(0))+"']","Users name");

        //verify name matches
        String HuluNames = Reusable_Actions.getTextMethod(driver,"//*[@class='jsx-1217424545 cu-pi-display-name']","display name");
        if (HuluNames.equals(Name.get(0))){
            System.out.println("User's name " +HuluNames+ " matches");
        }else {
            System.out.println("User's name is not matching, actual name is " + HuluNames);
        }

    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }

    //end of after suite

}//end of java class
