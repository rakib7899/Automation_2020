package Reusable_Library;

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

public class action1{
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    int rowCount;
    WritableWorkbook writablebook;
    WritableSheet wsheet;
    @BeforeMethod
    public void openBrowser() throws IOException, BiffException, InterruptedException, WriteException {
        //defined the path of Readable file
        readableFile = Workbook.getWorkbook(new File("/Users/rahpaid/Desktop/Maven Test/src/main/resources/Express.xls"));
        //define the work sheet for the data
        readableSheet = readableFile.getSheet(0);
        //get count of all non empty rows in your excel sheet
        rowCount = readableSheet.getRows();
        // create a duplicate work book to write back so it doesn't mess up your readable workbook
        writablebook = Workbook.createWorkbook(new File("/Users/rahpaid/Desktop/Maven Test/src/main/resources/Express Results.xls"), readableFile);
        // define the writable work sheet to read the data
        wsheet = writablebook.getSheet(0);

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //set pre arguments using ChromeOptions
        ChromeOptions Option = new ChromeOptions();
        Option.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(Option);
        //Annotation method to define your browser
    }
//STEP 1:

        @Test( priority = 0)
        public void Testcase1() throws InterruptedException, WriteException {

            for (int i = 1; i < rowCount; i++) {
                String zipCode = wsheet.getCell(0, i).getContents();
                //navigate to Express
                driver.navigate().to("http://www.express.com");
                Thread.sleep(3000);
//STEP 2:
                // get title and match
                reusable_methods.verifyPageTitle(driver, "Men’s and Women’s Clothing");

                //wait a few before continuing
                Thread.sleep(3000);
//STEP 3:
                //Hover on ‘Women’ tab using Actions //use contains @href property
                reusable_methods.mouseHover(driver, "//*[@href='/womens-clothing']", "/womens-clothing");
//STEP 4:
                //click on  ‘Dresses’ link //use contains @href property or you can use text() property
                reusable_methods.click(driver, "//*[@href='/womens-clothing/dresses/cat550007']", "/womens-clothing/dresses/cat550007");
//STEP 5:      //wait few seconds using Thread.sleep and Scroll about 400 to 500 pixels
                Thread.sleep(4000, 5000);
//STEP 6:      //Click on second image
                reusable_methods.click(driver, "//*[@class='swatch-images active']", 1, "pwrap front o-ring jumpsuit");
//STEP 7:       //wait few seconds on next page
                Thread.sleep(3000);
//STEP 8:       //On size page click on specific size(choose different size each time on excel) and the value should be passed in xpath
                reusable_methods.clickByMouse(driver, "//*[@value='xxs']", "XXS");

                Thread.sleep(3000);
//STEP 9:      //Click on ‘Add to Bag’ button
                reusable_methods.clickByMouse(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']","ADD TO BAG");
//STEP 10:     //on pop up to the right side click on ‘View Bag’ tab  then wait few seconds
                reusable_methods.click(driver, "//*[text()='View Bag']", "View bag");
                Thread.sleep(3000);
//STEP 11:     //Step 11: Select a quantity(choose different one each time)
// you can use dropdown reusable method by visible text which I created for you in reusable method class
                String quality= wsheet.getCell(1,i).getContents();
                reusable_methods.click(driver,"//*[@id='qdd-0-quantity']","q");
                reusable_methods.dropDownSelect(driver,"//*[@id='qdd-0-quantity']",quality,"q");


//STEP 12:     //Click on  ‘Checkout’ button then wait few seconds
                reusable_methods.click(driver,"//*[text()='Checkout']","Check Out");
                Thread.sleep(2000);
//STEP 13:     //on pop up click on ‘Continue as Guest’ button then wait few seconds
                reusable_methods.click(driver,"//*[text()='Continue as Guest']","guest");
                Thread.sleep(3000);
//STEP 14:     //Enter first name
                String Fname=wsheet.getCell(2,i).getContents();
                reusable_methods.type(driver,"//*[@name='firstname']",Fname,"first name");
//STEP 15:     //Enter last name
                String Lname=wsheet.getCell(3,i).getContents();
                reusable_methods.type(driver,"//*[@name='lastname']",Lname,"last name");
//STEP 16:     //Enter Email address(put invalid address)
                String address=wsheet.getCell(4,i).getContents();
                reusable_methods.type(driver,"//*[@type='email']",address,"address");

//STEP 17:     //Re-enter Email address(put same email above)
                String Email= wsheet.getCell(4,i).getContents();
                reusable_methods.type(driver,"//*[@name='confirmEmail']",Email,"email");
//STEP 18:     //enter phone number(invalid numeric 10 digit number)
                String phone= wsheet.getCell(5,i).getContents();
                reusable_methods.type(driver,"//*[@name='phone']",phone,"phone");
//STEP 19:     //Click on ‘Continue’ button
                Thread.sleep(3000);
                reusable_methods.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
//STEP 20:     //Click on ‘Continue’ button again
                reusable_methods.click(driver,"//*[@type='submit']","continue");
                Thread.sleep(3000);
//STEP 21:     //Enter address(invalid one. For instance, 111, 222, etc…)
                String Street=wsheet.getCell(6,i).getContents();
                reusable_methods.type(driver,"//*[@name='shipping.line1']",Street,"street");
//STEP 22:     //Enter zip code(different boroughs zipcode)
                String zipcode=wsheet.getCell(7,i).getContents();
                reusable_methods.type(driver,"//*[@name='shipping.postalCode']",zipcode,"zipcode");
//STEP 23:     //Enter city(different boroughs)
                String borough=wsheet.getCell(8,i).getContents();
                reusable_methods.type(driver,"//*[@name='shipping.city']",borough,"borough");
//STEP 24:    //Select state(keep as NY for zip codes)
                String state=wsheet.getCell(9,i).getContents();
                reusable_methods.click(driver,"//*[@name='shipping.state']","Dropdown");
                reusable_methods.dropDownSelect(driver,"//*[@name='shipping.state']",state,"state");
//STEP 25:    //click on continue button
                reusable_methods.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
                Thread.sleep(3000);

//STEP 26:    //Clear and Enter card number(use invalid card number for different card type. Look into examples of American express, discover, master & visa)
                String CreditCard = wsheet.getCell(10, i).getContents();
                String ExpireMonth = wsheet.getCell(11, i).getContents();
                String ExpireYr = wsheet.getCell(12, i).getContents();
                String CVV = wsheet.getCell(13, i).getContents();
                Thread.sleep(2000);
                //type Credit card info
                reusable_methods.type(driver, "//*[@name='creditCardNumber']", CreditCard, "credit card");
                Thread.sleep(1000);
                //Click Expire Month
                reusable_methods.click(driver, "//*[@name='expMonth']", "Click expire month");
                Thread.sleep(1000);
                //Dropdown to month Expire
                reusable_methods.dropDownSelect(driver, "//*[@name='expMonth']", ExpireMonth, "Expire Month");
                Thread.sleep(1000);
                //click expire yr
                reusable_methods.click(driver, "//*[@name='expYear']", "click");
                //Dropdown to Yrs Expire
                reusable_methods.dropDownSelect(driver, "//*[@name='expYear']", ExpireYr, "Expire years");
                Thread.sleep(2000);
                //type Cvv
                reusable_methods.type(driver, "//*[@name='cvv']", CVV, "CVV");
                Thread.sleep(1000);
                reusable_methods.click(driver, "//*[@type='submit']", "Click enter");
                Thread.sleep(1000);
                String errText = driver.findElement(By.xpath("//*[text()='Please enter a valid credit card number.']")).getText();
                Label errMessage = new Label(14, i, (errText));
                wsheet.addCell(errMessage);
                driver.manage().deleteAllCookies();
            }//loop
        }
    @AfterMethod
    public void EndBrowser() throws IOException, WriteException {
        writablebook.write();
        writablebook.close();
        readableFile.close();
        driver.quit();
        
            }}