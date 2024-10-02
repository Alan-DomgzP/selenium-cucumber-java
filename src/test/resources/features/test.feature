Feature: Automation practice
    A site to practice automation.

    Background:
    # Test 1
        Given we are on the automation practice page

    # Test 2
    @suggesstion_input 
    Scenario Outline: Suggestion input example
        When we type <entry> on the suggession input
        Then we validate <country> is in the list
        And select the country <country>
        Then we validate that <country> is shown in the input

        Examples:
            | entry | country              |
            | Me    | Mexico               |
            | Uni   | United States (USA)  |
            | Uni   | United Arab Emirates |
            | Col   | Colombia             |

    @listTest
    Scenario: Get suggestion input list
        When we type Wa on the suggession input
        Then we validate Washington is in the list

    # Test 3
    @dropdown
    Scenario Outline: Get dropdown menu options
        When we click on the dropdown example
        Then we select <menu_option> option
        And we validate that <menu_option> is the value shown in the dropdown

        Examples:
            | menu_option |
            | Option2     |
            | Option3     |

    # Test 6
    @alert
    Scenario: Switch To Alert Example
        When we fill the alert input with "Stori Card"
        Then we click the alert button
        And validate the alert text and close alert
        When we fill the alert input with "Stori Card"
        Then we click the confirm button
        And validate the confirm text and close alert

    # Test 7
    @courses_table
    Scenario: Course cost table
        Then we look for the courses table
        And we are searching for the $25 courses
        And we are searching for the $15 courses
        