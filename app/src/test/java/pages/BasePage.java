package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;


public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        String srcPath = System.getProperty( "user.dir" );
        System.setProperty("webdriver.chrome.driver",  srcPath + File.separator + "drivers" + File.separator + "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver( chromeOptions );
        wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
        action = new Actions( driver );
    }

    public BasePage ( WebDriver driver ) {
        BasePage.driver = driver;
        wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
    }

    public static void navigateTo ( String url ) {
        driver.get( url );
    }

    public static void closeBrowser () {
        driver.quit();
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();    
    }

    public void switchToWindow ( String windowTitle ) {
        searchWindow( windowTitle );
    }

    public void closeWindow( String windowTitle ) {
        searchWindow( windowTitle );
        driver.close();
    }

    public void searchWindow( String windowTitle ) {
        Set<String> windowsList = driver.getWindowHandles();
        List<String> windowList = new ArrayList<String>( windowsList );
        
        for( String e : windowList ){
            String title = driver.switchTo().window( e ).getTitle();
            System.out.println( "\n Window: " + driver.switchTo().window( e ).getTitle() );
            if( title.contains( windowTitle ) ) {
                driver.switchTo().window( e );
                System.out.println( e );
                System.out.println( "Switched to: " + driver.switchTo().window( e ).getTitle() );
            }
        }
    }

    public void switchTabForward () {
        driver.findElement( By.cssSelector( "body" ) ).sendKeys( Keys.CONTROL + "t" );
        System.out.println( "Switch tab forward" );
        System.out.println( driver.getTitle() );
    }

    public void switchTabBackward () {
        driver.findElement( By.cssSelector( "body" ) ).sendKeys( Keys.CONTROL + "\t" );
        System.out.println( "Switch tab backward" );
        System.out.println( driver.getTitle() );
    }
    //FUNCTIONS

    private WebElement Find ( String locator ) {
        return wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( locator ) ) );
        // MAKE A FUNCTION TO FIND ELEMENT BY ANY LOCATOR
    }

    public void clickElement ( String locator ) {
        Find( locator ).click();
    }

    public void write ( String locator, String textToWrite ) {
        Find( locator ).clear();
        Find( locator ).sendKeys( textToWrite );
    }

    public List<WebElement> bringMeAllElements ( String locator ) {
        return driver.findElements( By.className( locator ) );
    }

    public void selectNthelement ( String locator, int index ) {
        List<WebElement> results = driver.findElements( By.xpath( locator ) );
        results.get( index ).click();
    }

    public void selectFromDropdownByText ( String locator, String valueToSelect ) {
        Select dropdown = new Select( Find( locator ) );
        dropdown.selectByVisibleText( valueToSelect );
    }

    public String textFromElement ( String locator) {
        return Find( locator ).getText();
    }

    public boolean elementIsDisplayed( String locator ){
        return Find( locator ).isDisplayed();
    }

    public boolean elementIsDisplayed2( String locator ){
        return driver.findElement( By.className( locator ) ).isDisplayed();
    }

    public void scrollPageDownByPixels ( String horizontal , String vertical ) {
        JavascriptExecutor js = ( JavascriptExecutor ) driver;  
        js.executeAsyncScript( "scroll(" + horizontal + "," + vertical + ")" );
    }

    public void scrollPageDownToElement( String locator ) {
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript( "arguments[0].scrollIntoView(true);", Find( locator ) );
    }

    public void takeScreenShot ( String screenShotName ) throws IOException {
        
        File file = ( (TakesScreenshot) driver ).getScreenshotAs( OutputType.FILE );
        String srcPath = System.getProperty( "user.dir" );
        String screenShotPath = srcPath + File.separator + "test-output" + File.separator + screenShotName + ".png";
        FileUtils.copyFile( file, new File( screenShotPath ) );
        System.out.println( screenShotPath );
    }
    
    

}

