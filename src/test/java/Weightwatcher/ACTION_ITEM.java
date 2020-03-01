package Weightwatcher;

import Reusable_Library.reusable_methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ACTION_ITEM {

        WebDriver driver;
        Workbook readableFile;
        Sheet readableSheet;
        int rowCount;
        WritableWorkbook writablebook;
        WritableSheet wsheet;
        @BeforeMethod
        public void openBrowser() throws IOException, BiffException, InterruptedException, WriteException {
            //1,defined the path of Readable file
            readableFile = Workbook.getWorkbook(new File("/Users/rahpaid/Desktop/Maven Test/src/main/resources/Data Driven.xls"));
            //Step2: define the work sheet for the data
            readableSheet = readableFile.getSheet(0);

            //Step 3: get count of all non empty rows in your excel sheet
            rowCount = readableSheet.getRows();
            //Step 4: create a duplicate work book to write back so it doesn't mess up your readable workbook
            writablebook = Workbook.createWorkbook(new File("/Users/rahpaid/Desktop/Maven Test/src/main/resources/data driven results.xls"), readableFile);
            //Step 5: define the writable work sheet to read the data
            wsheet = writablebook.getSheet(0);


            //define the path of chrome driver
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            //set pre arguments using ChromeOptions
            ChromeOptions Option = new ChromeOptions();
            Option.addArguments("start-maximized", "incognito");
            driver = new ChromeDriver(Option);
        }//Annotation method to define your browser

        @Test( priority = 0)
        public void Testcase1() throws InterruptedException, WriteException {
            driver.navigate().to("https://www.weightwatchers.com/us/");
            for (int i = 1; i < rowCount; i++) {
                String zipCode = wsheet.getCell(0, i).getContents();
                //navigate to Wightwatcher
                //driver.navigate().to("https://www.weightwatchers.com/us/");
                Thread.sleep(3000);
                // get title and match
                reusable_methods.verifyPageTitle(driver, "Weight Loss Program, Recipes & Help | Weight Watchers");


                //click on find studio
                //Reusable_Methods.click(driver,"//*[@class='find-a-meeting']","Find a Studio");
                driver.findElement(By.xpath("//*[text()='Find a Studio']")).click();
                Thread.sleep(3000);
                reusable_methods.verifyPageTitle(driver, "Find a Studio & Meeting Near You");

                Thread.sleep(3000);
                // click on the pop to exit and type in search button
                    reusable_methods.click(driver, "//*[@class='bx-close-xsvg']", "Close Pop Up");

                //enter zipcode on the search bar
                reusable_methods.type(driver, "//*[@id='meetingSearch']", zipCode, "meetingSearch");

                //click search.
                reusable_methods.click(driver, "//*[text()='Submit']", "Submit");
                Thread.sleep(3000);
                // Get the name of the location and the distance
                String resultText = driver.findElement(By.xpath("//*[@class ='location__name']")).getText();
                String locationMiles = driver.findElement(By.xpath("//*[@class ='location__distance']")).getText();

                Thread.sleep(2000);
                Label milesValue = new Label(1, i, resultText + locationMiles);
                wsheet.addCell(milesValue);
                // click on the first link in results
                reusable_methods.click(driver, "//*[@class ='location__top']", "WW Studio Park Slope");
                Thread.sleep(3000);
                String OperationHours = driver.findElement(By.xpath("//*[@class ='schedule-detailed-day']")).getText();
                Label hoursValue = new Label(2, i, (OperationHours));
                wsheet.addCell(hoursValue);
            }//test case 1
        }//end loop
        @AfterMethod
        public void closedriver() throws IOException, WriteException {
            writablebook.write();
            writablebook.close();
            readableFile.close();

            driver.close();





        }//end of main method

    }//end of class




