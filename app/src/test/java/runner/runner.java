package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    monochrome = true, //Realiza un output más limpio en consola
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    tags = "@Test" //Para pasar un solo tag
)

public class runner {
   @AfterClass
    public static void cleanDriver () {
        // BasePage.closeBrowser();
    }
}
