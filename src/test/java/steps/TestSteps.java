package steps;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.AutomationPage;


public class TestSteps {

    AutomationPage test = new AutomationPage();
    
    @Given("we are on the automation practice page")
    public void iNavigateTo() {
        test.goToPage();
    }

    @When("^we type (.*) on the suggession input$")
    public void writeOnSuggestionOInput(String entry) {
        test.writeInput(entry);
    }

    @Then("^we validate (.*) is in the list$")
    public void validateList(String country) {
        List<String> lista = test.getAllElements();
        // boolean textIsThere = lista.contains(country);
        // System.out.println("Lista: " + lista);

        Assert.assertTrue(lista.contains(country));
 
        // if (textIsThere) {
        //     System.out.println(country + " is in the list: PASSED.");
        // } else {
        //     throw new Error(country + " is not in the list: FAILED.");
        // }
    }

    @And("^select the country (.*)$")
    public void selectcountry(String country) {
        test.selectCountryInList(country);
    }
    
    
    @Then("^we validate that (.*) is shown in the input$")
    public void validateInputValue( String country) {
        Assert.assertEquals( test.validateInputValue(), country);
    }


    @When("we click on the dropdown example")
    public void clickDropdown() {
        test.clickDropdown();
    }

    @Then("^we select (.*) option$")
    public void selectDropdownValue(String menu_option) {
        test.selectDropdownValue(menu_option);
    }

    @And("^we validate that (.*) is the value shown in the dropdown$")
    public void validateDropdwonValue(String value) {
        Assert.assertEquals( test.validateDropdownText(), value.toLowerCase() );
    }
    
}
