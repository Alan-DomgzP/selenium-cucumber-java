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

    @When("^we fill the alert input with (.*)$")
    public void fillAlertInput(String text) {
        test.fillAlert(text.replace("\"", ""));
    }

    @Then("^we click the (.*) button$")
    public void clickAlert(String type) {
        test.clickAlertButton(type);
    }
    
    @And("^validate the (.*) text and close alert$")
    public void validateAlert(String type) throws InterruptedException {
        String textToValidate = "";
        if( type.equals("alert") ) {
            textToValidate = "Hello Stori Card, share this practice page and share your knowledge";
        } else {
            textToValidate = "Hello Stori Card, Are you sure you want to confirm?";
        }

        Assert.assertEquals(test.getAlertText(), textToValidate);
        test.dismissAlert();
    }

    @Then("we look for the courses table")
    public void coursesTable() {
        test.searchCourseTable();
    }

    @And("^we are searching for the \\$([0-9]+) courses$")
    public void coursesPrice(String price) {
        List<String> coursesList = test.getAllElementsInCoursesTable(price);

        System.out.println(price);
        System.out.println("Lista: " + coursesList);

        // Assert.assertFalse(coursesList.isEmpty(), "Not items where found with given criteria: " + price);
        if( coursesList.isEmpty() ){ 
            System.out.println("Not items where found with given criteria: " + price);
        }
    }

    @Then("we look for the employees table")
    public void employeesTable() {
        test.searchEmployeesTable();
    }

    @And("^we are searching all the (.*)$")
    public void employeePosition(String position) {
        String singular_position = test.convertToSingular(position);
        List<String> employeeList = test.getAllElementsInEmployeesTable(singular_position);

        System.out.println(singular_position);
        System.out.println("Lista: " + employeeList);

        if( employeeList.isEmpty() ){ 
            System.out.println("Not items where found with given criteria: " + employeeList);
        }
    }

}


