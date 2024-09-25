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
        # And select the country <country>