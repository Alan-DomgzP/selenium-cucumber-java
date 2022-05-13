package steps;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.*;
import pages.TestPage;

public class TestSteps {

    TestPage page = new TestPage();

    @Given("^I am on the automation practice page$")
    public void navigateToPage () {
        page.navigateToPage();
    }

    @Then("^write Me on suggestion class input$")
    public void writeSuggestion () {
        page.enterSearchCriteria( "Me" );
        // page.getAllSearchResults();
    }

    @And("^select Mexico option from the list$")
    public void selectCountry () {
        // List<String> lista = 
        page.getAllSearchResults();
        // boolean textIsThere = lista.contains( "Mexico" );
        // System.out.println( lista );

        // if( textIsThere ){
        //     System.out.println( "The text is on the list: PASSED!" );
        // } else {
        //     throw new Error( "The text is not on the list: FAILED!" );
        // }
    }

    

    ///////////////////////////////////////
    @Given("^I click the Dropdown example$")
    public void clickDropdownList () {
        page.clickDropdownList();
    }

    @And("^select option Option2 from the dropdown$")
    public void selectListOption () {
        page.clickDropdownList();
        page.selectDropdownOption( "Option2" );
    }

    @And("^change option to Option3 from the dropdown$")
    public void selectAnotherListOption () {
        page.clickDropdownList();
        page.selectDropdownOption( "Option3" );
    }



    ///////////////////////////////////////
    @Given("^I click the switch window button$")
    public void clickSwitchWindowButton () {
        page.clickSwitchWindowButton();
    }    

    @Then("^I need to close the modal displayed$")
    public void closeModal () { 
        String changeToWindow = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
        page.switchNewWindow( changeToWindow );
    }

    @And("^scrolldown the page$")
    public void scrollDownToGuaranteeText () { 
        page.scrollDownToGuaranteeText();
    }

    @And("^validate 30 day money back guarantee text$")
    public void validateGuaranteeText () {
        String changeToWindow = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
        page.validateText( "30 DAY MONEY BACK GUARANTEE", changeToWindow );
    }



    ///////////////////////////////////////
    @Given("^I click the switch tab button$")
    public void clickSwitchTabButton () { 
        String changeToWindow = "Practice Page";
        page.switchTab( changeToWindow );
        page.clickSwitchTabButton();
    }

    @Then("^scrolldown to the view all courses button$")
    public void scrollDownToElement () throws IOException, InterruptedException {
        String changeToWindow = "Rahul Shetty Academy";
        page.switchTab( changeToWindow );
        page.scrollDownToElement();
    }

    ///////////////////////////////////////
    @Given("^I click on the input alert$")
    public void inputAlertButton () { 
        String changeToWindow = "Practice Page";
        page.switchTab( changeToWindow );
    }
    
    @Then("^write Stori Card on switch to alert input$")
    public void writeAlertInput () throws IOException, InterruptedException {
        page.writeAlertInput( "Stori Card" );
    }

    // @And("^click on the alert button$")
    // public void clickAlertButton () {
    //     page.clickAlertButton();
    // }




}
