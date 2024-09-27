package runner;

import steps.Utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", 
    glue = "steps",
    plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
    tags="@dropdown"
)
 
public class TestRunner {

    @BeforeClass
    public static void setUpAllureProperties() throws IOException, InterruptedException {
        Utils.validateAndCreateDirectories();
        // String reportLocation = Utils.getLastReportFolderName("reports");
        // Utils.updateAllureResultsDirectory(reportLocation);
    }
    
    @AfterClass
    public static void cleanDriver() {
        BasePage.closeBrowser();
    }
}
