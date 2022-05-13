package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class TestPage extends BasePage {
        
    private String suggestionInput = "/html[1]/body[1]/div[1]/div[2]/fieldset[1]/input[1]";
    private String searchResults = "ui-menu-item-wrapper";
    private String dropdownList = "//select[@id='dropdown-class-example']";
    private String switchWindowButton = "/html[1]/body[1]/div[2]/div[1]/fieldset[1]/button[1]";
    private String elementTextToValidate = "//h3[contains(text(),'30 day Money Back Guarantee')]";
    private String modal = "//body/div[4]/div[2]/div[1]/div[1]/div[1]";
    private String closeModal = "//body/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[7]/div[1]/div[1]/div[2]";
    private String switchTabButton = "//a[@id='opentab']";
    private String coursesButton = "//a[contains(text(),'VIEW ALL COURSES')]";
    private String alertInput = "/html[1]/body[1]/div[2]/div[3]/fieldset[1]/input[1]";
    private String alertButton = "//input[@id='alertbtn']";

    
    public TestPage () {
        super( driver );
    }

    public void navigateToPage() {
        navigateTo( "https://rahulshettyacademy.com/AutomationPractice/" );
        maximizeWindow();
    }

    public void enterSearchCriteria( String criteria ) {
        write( suggestionInput, criteria );
    }

    // public List<String> getAllSearchResults () {
    //     List<WebElement> list = bringMeAllElements( searchResults );
    //     List<String> stringsFromList = new ArrayList<String>();

    //     for( WebElement e: list ) {
    //         stringsFromList.add( e.getText() );
    //         System.out.println( e.getText() );
    //     }
    //     return stringsFromList;
    // }

    public void getAllSearchResults () {
        List<WebElement> list = bringMeAllElements( searchResults );
        elementIsDisplayed2( searchResults );

        System.out.println( list );
        System.out.println( elementIsDisplayed2( searchResults ) );
    }

    public void clickDropdownList() {
        clickElement( dropdownList );
    }

    public void selectDropdownOption( String valueToSelect ) {
        selectFromDropdownByText( dropdownList, valueToSelect );
    }
    
    public void clickSwitchWindowButton() {
        clickElement( switchWindowButton );
    }
    
    public void switchNewWindow( String windowTitle ) {
        switchToWindow( windowTitle );
        // maximizeWindow();

        if( elementIsDisplayed( modal ) ) {
            System.out.println( "Modal is shown: " + elementIsDisplayed( modal ) );
            clickElement( closeModal );
            System.out.println( "Modal closed" );
        }
    }

    public void scrollDownToGuaranteeText () {
        scrollPageDownToElement( elementTextToValidate );
    }

    public void validateText ( String validateText, String windowTitle ) {
        
        String actual = textFromElement( elementTextToValidate );

        if( actual.contains( validateText ) )
            System.out.println( "The text was validated!" );
        else
            System.out.println( "The text not validated!" );
        
        Assert.assertEquals( validateText, actual );
        closeWindow( windowTitle );
        // closeBrowser();
    }
    
    public void clickSwitchTabButton() {
        clickElement( switchTabButton );
    }
    
    public void switchTab( String windowTitle ) {
        switchToWindow( windowTitle );
    }

    public void scrollDownToElement() throws IOException, InterruptedException{
        scrollPageDownToElement( coursesButton );

        if( elementIsDisplayed( coursesButton ) ){
            System.out.println( "Button Found!" );
            Thread.sleep( 800 );
            System.out.println( "Take Screeenshot" );
            takeScreenShot( "View_all_courses_button" );
        }
    }

    
    public void switchTabBack () {
        switchTabBackward();
    }

    public void switchTabForkward() {
        switchTabForward();
    }

    public void writeAlertInput ( String criteria ) {
        write( alertInput, criteria );
    }
    
    public void clickAlertButton() {
        clickElement( alertButton );
    }
    
}
