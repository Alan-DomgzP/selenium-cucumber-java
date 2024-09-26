package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import pages.BasePage;

public class Hooks extends BasePage {
    
    public Hooks() {
        super(driver);
    }

    @Before
    public void setup() throws IOException, InterruptedException {
        Utils.validateAndCreateDirectories();
        // Thread.sleep(600);
        String reportLocation = Utils.getLastReportFolderName("reports");
        System.out.println("PATH REPORTES: " + reportLocation);
        System.setProperty("allure.results.directory", reportLocation);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if( scenario.isFailed() ) {
            scenario.log("Scenario failed!");
            scenario.log("For more information, please refer to the report");
            File screenshotFile = takeScreenShot( scenario.getName() );
            Allure.addAttachment("Screenshot ", FileUtils.openInputStream( screenshotFile ) );
        }
    }

    public static File takeScreenShot ( String screenShotName ) {
        
        File file = ( (TakesScreenshot) driver ).getScreenshotAs( OutputType.FILE );
        String srcPath = System.getProperty( "user.dir" );
        String screenShotPath = "";

        try {
            screenShotPath = srcPath + File.separator + Utils.getLastReportFolderName("screenshots") + File.separator + screenShotName.replace(" ", "_") + ".png";
            System.out.println( "SS path: " + screenShotPath );
            FileUtils.copyFile( file, new File( screenShotPath ) );
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
