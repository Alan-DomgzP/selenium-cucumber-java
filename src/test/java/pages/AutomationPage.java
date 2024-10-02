package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationPage extends BasePage {

    private String suggestionInput = "//input[@id='autocomplete']";
    // CLASSNAME SUGGESTION INPUT
    // private String sugesstionResults = "ui-menu-item-wrapper";
    // RELATIVE XPATH SUGGESTION INPUT
    private String sugesstionResults = "//div[starts-with(@id, 'ui-id-')]";
    private String dropdownElement = "//select[@id='dropdown-class-example']";
    private String dropdownOption = "//option[@value='%s']";

    private String alertInput = "//input[@id='name']";
    private String alertButton = "//input[@id='alertbtn']";
    private String confirmButton = "//input[@id='confirmbtn']";
    // CSS SELECTOR
    // private String alertButton = "#alertbtn";
    // private String confirmButton = "#confirmbtn";
    
    // private String table_courses = "table[name='courses'] tbody tr td:nth-child(3)"; //For the 3rd column
    private String courses_table = "table[name='courses'] tbody tr";
    private String employees_table = "body > div:nth-child(5) > div:nth-child(2) > fieldset:nth-child(2) > div:nth-child(2) > table:nth-child(1) tbody tr";
    private String iframe = "//iframe[@id='courses-iframe']";
    private String highlighted_blue = "//li[contains(text(),'His mentorship program is most after in the softwa')]";

    private String xpathLocator = "xpath";
    private String cssSelector = "cssSelector";

    // private String searchInput = "//div[@id='the-basics']//input[@placeholder='States of USA']";
    // private String searchResults = "tt-suggestion";
    
    public AutomationPage() {
        super(driver);
    }

    public void goToPage() {
        navigateTo("https://rahulshettyacademy.com/AutomationPractice/");
        // navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void writeInput( String entry ){
        write(xpathLocator, suggestionInput, entry);
    }

    public List<String> getAllElements() {
        List<WebElement> list = getListOfElements( xpathLocator, sugesstionResults);
        List<String> elementStringList = new ArrayList<>();
        
        for (WebElement e : list) {
           elementStringList.add( e.getText() );
        }
        return elementStringList;
    }
    
    public void selectCountryInList( String country ) {
        selectItemInList(xpathLocator, sugesstionResults, country);
    }

    public String validateInputValue() {
        return getElementTxtFromAttribute(xpathLocator, suggestionInput);
    }

    public void clickDropdown() {
        clickElement(xpathLocator, dropdownElement);
    }

    public void selectDropdownValue( String option ) {
        // selectFromDropdownByText( xpathLocator, dropdownElement, option);
        String value = String.format(dropdownOption, option.toLowerCase());
        clickElement(xpathLocator, value);
    }

    public String validateDropdownText() {
        return getElementTxtFromAttribute(xpathLocator, dropdownElement);
    }
    
    public void fillAlert( String text ) {
        write(xpathLocator, alertInput, text);
    }

    public void clickAlertButton( String type ) {
        String buttonToClick = ( type.equals("alert") ) ? alertButton : confirmButton;
        clickElement(xpathLocator, buttonToClick);
        // clickElement(cssSelector, buttonToClick);
    }

    public String getAlertText() {
        return alertActions("getText");
    }

    public void dismissAlert() throws InterruptedException {
        Thread.sleep(600);
        alertActions("dismiss");
    }

    public void searchCourseTable() {
        scrollAndFindElement(cssSelector, courses_table);
    }

    public List<String> getAllElementsInCoursesTable( String val ) {
        Boolean elementIsPresent = isElementPresent(cssSelector, courses_table);
        List<String> elementStringList = new ArrayList<>();

        if( elementIsPresent ) {
            List<WebElement> rows = getListOfElements( cssSelector, courses_table );
            
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if ( cells.size() > 0 ) {
                    String price = cells.get(2).getText();
                    if ( price.equals( val )) {
                        String courseName = cells.get(1).getText();
                        elementStringList.add(courseName);
                    }
                }
            }
        }

        return elementStringList;
    }

    public void searchEmployeesTable() {
        scrollAndFindElement(cssSelector, employees_table);
    }

    public String convertToSingular( String position ) {
        if (position.endsWith("s")) {
            return position.substring(0, position.length() - 1);
        }
        return position;
    }

    public List<String> getAllElementsInEmployeesTable( String val ) {
        List<String> elementStringList = new ArrayList<>();
        List<WebElement> rows = getListOfElements( cssSelector, employees_table );
            
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if ( cells.size() > 0 ) {
                String position = cells.get(1).getText();
                if ( position.equals( val ) ) {
                    String employeeName = cells.get(0).getText();
                    elementStringList.add(employeeName);
                }
            }
        }

        return elementStringList;
    }

    public void moveToiFrame(){
        scrollAndFindElement(xpathLocator, iframe);
    }

    public void switchToiFrame() {
        switchToiFrame("courses-iframe");
    }

    public String getText() {
        scrollAndFindElement(xpathLocator, highlighted_blue);
        return getElementTxt(xpathLocator, highlighted_blue);
    }

    public String oddIndexes(String text) { 
        String[] words = text.split(" ");
        List<String> oddIndexWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (i % 2 != 0) {
                oddIndexWords.add(words[i]);
            }
        }
        return String.join(" ", oddIndexWords);
    }
}


