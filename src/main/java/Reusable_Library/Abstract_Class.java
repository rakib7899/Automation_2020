package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void openBrowser() throws InterruptedException, BiffException, IOException, WriteException {
        //define the path where you want to save the Extent Report
        reports = new ExtentReports("src/main/java/Extent_Reports/Automation.html", true);
    }//end of before suite

    //before method will be used to capture the test name and start the report
    @Parameters("browser")
    @BeforeMethod
    public void getTestName(String browser,Method methodName){
        if(browser.equalsIgnoreCase("Chrome")) {
            //create a path to chrome
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            //set pre agrs using chromeOPTIONS
            ChromeOptions options = new ChromeOptions();
            //chrome options
            options.addArguments("start-maximized", "incognito");
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("Firefox")){
            //create a path to chrome
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        logger = reports.startTest(methodName.getName() + " - " + browser);
    }//end of before method

    //after method will end your test report
    @AfterMethod
    public void endReport(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quitSession(){
        //write all your logs back to the report
        reports.flush();
        //quit driver if you need to
        //driver.quit();
    }//end of after suite




}//end of abstract class
