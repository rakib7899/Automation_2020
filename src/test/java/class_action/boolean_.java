package class_action;

import Reusable_Library.reusable_methods;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class boolean_ {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws IOException, BiffException, InterruptedException, WriteException {
        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //set pre arguments using ChromeOptions
        ChromeOptions Option = new ChromeOptions();
        Option.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(Option);
        //Annotation method to define your browser
    }//end of before method
    @Test
    private void yahoo() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        //Store your find elements using list command to get the group count
     //VERIFY PAGE TITLE
        Thread.sleep(4000);
        reusable_methods.verifyPageTitle(driver,"Google");
        Thread.sleep(3000);
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib)')"));
        System.out.println("My Link count is " + linkCount.size());

        Thread.sleep(3000);

//verify checkbox

        reusable_methods.click(driver,"//*[text()='Sign in']","Sign in");
        Thread.sleep(3000);
        Boolean checkbox=driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkbox==true){
            System.out.println("Stay signed in checkbox is selected");
        }else {
            System.out.println("Stay signed in is not selected");
    }


}}
