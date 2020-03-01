package class_action;

import Reusable_Library.Abstract_Class;
import Reusable_Library.reusable_methods_reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google_Search extends Abstract_Class {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    @BeforeMethod
    public void openBrowser() throws InterruptedException, BiffException, IOException, WriteException {
        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //set pre arguments using ChromeOptions
        ChromeOptions Option = new ChromeOptions();
        Option.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(Option);
        //Annotation method to define your browser
    }//end of before method


    @Test(priority = 1)
    public void googleSearch() throws InterruptedException, IOException {

        String[] cars;
        cars= new String[4];
        cars[0] = "BMW";
        cars[1] = "Mercedes";
        cars[2] = "Lexus";
        cars[3] = "Nissan";

        //for(int i = 0; i< 1;i++) {
        //navigate to google.com
        reports = new ExtentReports("src/main/java/Extent_Reports",true);
        logger.log(LogStatus.INFO,"Navigating to google home");
        driver.navigate().to("https://www.google.com/");
        //enter brooklyn in your search field
        reusable_methods_reports.type(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit on google search
        reusable_methods_reports.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        //capture the text into a string variable
        //Thread.sleep(3000);
        String message = reusable_methods_reports.captureText(driver,"//*[@id='mBMHK']",logger,"Search Result");
        String[] arraymessage = message.split(" ");
        //print out search number
        Thread.sleep(3000);
        System.out.println("My search number for "  + " is " + arraymessage[1]);
        logger.log(LogStatus.INFO,"My search number for " +" is " + arraymessage[1]);}
    // }//end of for loop
    //end the logger


}//end of test method



//end of parent class





