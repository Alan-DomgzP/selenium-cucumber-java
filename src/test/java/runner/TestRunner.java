package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", 
    glue = "steps", 
    plugin = { "pretty", "html:target/cucumber-reports" }, tags="@dropdown"
)
 
public class TestRunner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}


// Options to run tagged tests

// Va a correr Scenarios taggeados con @Plan
// gradle test -Dcucumber.filter.tags="@Plans"

// Va a correr todos los Scenarios que no tengan el tag @Plan
// gradle test -Dcucumber.filter.tags="Not @Plans"

// Va a correr todos los scenarios que tengan ambos, @Plan y @Courses tags al mismo tiempo. 
// gradle test -Dcucumber.filter.tags="@Plans" and "@Courses"

// Va a correr los scenarios que tengan los tags @Plans o @Courses (osea...todos los scenarios que tengan uno u otro).
// gradle test -Dcucumber.filter.tags="@Plans" or "@Courses"

// Va a correr todos los scenarios que tengan el tag "@Plans" y no tengan "@Courses".
// gradle test -Dcucumber.filter.tags="@Plans" and not "@Courses"