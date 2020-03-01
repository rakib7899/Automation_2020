package PageObjects.Google_POM;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    //Constructor method is when a child sub class having identical
    // name a parent class
    ExtentTest logger;
    //Constructor
    public SearchResultPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }
    public Homepage userSearch(String userValue) {


    }
