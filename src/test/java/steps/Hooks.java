package steps;

import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import pages.BasePage;

public class Hooks extends BasePage {
    
    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if( scenario.isFailed() ) {
            scenario.log("Scenario failing, please refer to the image attached to respective report");
            File screenshotFile = takeScreenShot( scenario.getName() );
            Allure.addAttachment("Screenshot ", FileUtils.openInputStream( screenshotFile ) );
        }
    }

    public static File takeScreenShot ( String screenShotName ) {
        
        File file = ( (TakesScreenshot) driver ).getScreenshotAs( OutputType.FILE );
        String srcPath = System.getProperty( "user.dir" );
        String screenShotPath = "";

        try {
            screenShotPath = srcPath + File.separator + "reports/screenshots" + File.separator + screenShotName.replace(" ", "_") + ".png";
            System.out.println( "SS path: " + screenShotPath );
            FileUtils.copyFile( file, new File( screenShotPath ) );
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
