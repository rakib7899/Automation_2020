package Cucumber.StepDefine;

import Reusable_Library.reusable_methods;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTestCases {

    WebDriver driver;

    @Given("^I navigate to google home$")
    public void navigate() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //set pre agrs using chromeOPTIONS
        Thread.sleep(3000);
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com/");
    }//end

    @When("^I Can verify the expected title as google$")
    public void VerifyTitle() throws InterruptedException {
        Thread.sleep(3000);
        reusable_methods.verifyPageTitle(driver,"Google");

    }//end of when

    @When("^I type a car (.*) in google search field$")
    public void typeOnSearch(String cars)throws InterruptedException {
        Thread.sleep(3000);
        reusable_methods.type(driver,"//*[@name='q']",cars,"Search Field");

    }//end of when

    @And("^I submit or click on google search$")
    public void clickOnSearch() throws InterruptedException {
        Thread.sleep(3000);
        reusable_methods.submit(driver,"//*[@name='q']","Search Field");

    }//end of and

    @Then("^Then I capture and extract the search number$")
    public void getSearchNumber() throws InterruptedException {
        Thread.sleep(3000);
      String message= reusable_methods.captureText(driver,"//*[@id='id=result-stats']", "Search Result");
      String[] arrayMsg= message. split(" ");
      Reporter.addStepLog("My Search number for car is" + arrayMsg[1]);
      System.out.println("My search number for cars is "+arrayMsg[1]);


    }//end of then

}//end of parent class