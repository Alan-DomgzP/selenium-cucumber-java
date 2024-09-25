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
        selectFromDropdownByText( xpathLocator, dropdownElement, option);
    }

    public String validateDropdownText() {
        return getElementTxt(xpathLocator, dropdownElement);
    }
    
}
