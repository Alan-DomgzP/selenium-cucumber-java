Feature: Test cases for the Automation Practice Page

@Test
Scenario: As a user I enter to the automationpractice page
   Given I am on the automation practice page
   Then write Me on suggestion class input
   # And select Mexico option from the list

@Test
Scenario: As a user I click in the Dropdown example and select Option2 and then Option3
   Given I click the Dropdown example
   Then select option Option2 from the dropdown
   And change option to Option3 from the dropdown

@Test
Scenario: As a user I need to click on switch window button
   Given I click the switch window button
   Then I need to close the modal displayed
   And scrolldown the page
   And validate 30 day money back guarantee text

@Test
Scenario: As a user I need to click on switch tab button
   Given I click the switch tab button
   Then scrolldown to the view all courses button

@Test
Scenario: As a user I need to type on the alert input
   Given I click on the input alert
   Then write Stori Card on switch to alert input
   # And click on the alert button
   #And click ok on the alert window
   # Then I write Stori Card
   # And click confirm
   