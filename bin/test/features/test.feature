Feature: Automation practice
    A site to practice automation.

    Background:
        Given we are on the automation practice page

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
    

    @dropdown
    Scenario Outline: Get dropdown menu options
        When we click on the dropdown example
        Then we select <menu_option> option
        And we validate that <menu_option> is the value shown in the dropdown
    
        Examples:
            | menu_option |
            | Option2     |
            | Option3     |

    @alert
    Scenario: Switch To Alert Example
        When we fill the alert input with "Stori Card"
        Then we click the alert button
        And validate the alert text and close alert
        When we fill the alert input with "Stori Card"
        # Then we click the confirm button
        # And we validate the alert text