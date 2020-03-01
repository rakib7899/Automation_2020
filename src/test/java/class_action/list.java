package class_action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class list {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //set pre arguments using ChromeOptions
        ChromeOptions Option = new ChromeOptions();
        Option.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(Option);
        //Annotation method to define your browser
        //initiate implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //end of before method
        }
        @Test
    private void usps() throws InterruptedException {
            driver.navigate().to("https://usps.com/");
            //Store your find elements using list command to get the group count
            List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'lang-')"));
            System.out.println("My Link count is " + linkCount.size());
        }
            public void closeBrowser(){

        }}
