package PageObjects.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.reusable_methods_reports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Abstract_Class {

    //Constructor method is when a child sub class having identical
    // name a parent class
    ExtentTest logger;
  //Constructor
    public Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger=super.logger;
    }
    public Homepage userSearch(String useValue){
        String searchFieldLoc="//*[@name='q']";

        reusable_methods_reports.type(driver,"",useValue,logger,"Search Field");

        reusable_methods_reports.submit(driver,searchFieldLoc,useValue,);



        return new Homepage(driver);
    }}
/*@FindBy(xpath = "//*[@name='q']")
    public static WebElement searchKeyLocator;
@FindBy(xpath ="//*[@id='btnK']" )
    public static WebElement searchIconLocator;
@FindBy(xpath = "//*[@=)
/*


}//end
