package Cucumber.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ("src/test/java/Cucumber/Features"),
        glue = ("Cucumber.StepDefine"),
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}

)
//end of your feature path
public class executableClass {













}
