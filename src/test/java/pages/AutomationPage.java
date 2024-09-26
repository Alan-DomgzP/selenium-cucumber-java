package pages;

import java.util.ArrayList;
import java.util.List;

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
    // private String cssSelector = "cssSelector";

    private String xpathLocator = "xpath";

    // private String searchInput = "//div[@id='the-basics']//input[@placeholder='States of USA']";
    // private String searchResults = "tt-suggestion";
    
    public AutomationPage() {
        super(driver);
    }

    public void goToPage() {
        navigateTo("https://rahulshettyacademy.com/AutomationPractice/");
        // navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void writeInput(String entry){
        // Thread.sleep(600);
        write(xpathLocator, suggestionInput, entry);
    }

    public List<String> getAllElements() {
        List<WebElement> list = getListOfElements(sugesstionResults);
        List<String> elementStringList = new ArrayList<>();
        
        for (WebElement e : list) {
           elementStringList.add( e.getText() );
        }
        return elementStringList;
    }
    

    public void selectCountryInList(String country) {
        selectItemInList(sugesstionResults, country);
    }

    public String validateInputValue() {
        return getElementTxt(xpathLocator, suggestionInput);
    }

    public void clickDropdown() {
        clickElement(xpathLocator, dropdownElement);
    }

    public void selectDropdownValue(String option) {
        // selectFromDropdownByText( xpathLocator, dropdownElement, option);
        String value = String.format(dropdownOption, option.toLowerCase());
        clickElement(xpathLocator, value);
    }

    public String validateDropdownText() {
        return getElementTxt(xpathLocator, dropdownElement);
    }
    
    public void fillAlert(String text) {
        write(xpathLocator, alertInput, text);
    }

    public void clickAlertButton(String type) {
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
}
