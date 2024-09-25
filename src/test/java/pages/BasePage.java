package pages;
 
// Importaciones necesarias
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BasePage {

    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static {
        WebDriverManager.chromedriver().setup();
        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void waitGivenSeconds( Integer seconds ){ 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( seconds ));
    }
 
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static By getBy(String type, String locator) {
        switch (type) {
            case "id":
                return By.id(locator);
            case "name":
                return By.name(locator);
            case "className":
                return By.className(locator);
            case "tagName":
                return By.tagName(locator);
            case "linkText":
                return By.linkText(locator);
            case "partialLinkText":
                return By.partialLinkText(locator);
            case "cssSelector":
                return By.cssSelector(locator);
            case "xpath":
                return By.xpath(locator);
            default:
                throw new IllegalArgumentException("Locator " + type + " is not supported");
        }
    }

    private WebElement Find(String locatorType, String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated( getBy( locatorType, locator) ));
    }
 
    public void clickElement(String locatorType, String locator) {
        Find(locatorType, locator).click();
    }

    public String getElementTxt(String locatorType, String locator) {
        // return Find(locatorType, locator).getText();
        return Find(locatorType, locator).getAttribute("value");
    }

    public void write(String locatorType, String locator, String keysToSend) {
        Find(locatorType, locator).clear();
        Find(locatorType, locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locatorType, String locator, String value) {
        Select dropdown = new Select(Find(locatorType, locator));
 
        dropdown.selectByValue(value);
    }
 
    public void selectFromDropdownByIndex(String locatorType, String locator, Integer index) {
        Select dropdown = new Select(Find(locatorType, locator));
 
        dropdown.selectByIndex(index);
    }

    public void selectFromDropdownByText(String locatorType, String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locatorType, locator));
 
        dropdown.selectByVisibleText(valueToSelect);
    }
 
    public int dropdownSize(String locatorType, String locator) {
        Select dropdown = new Select(Find(locatorType, locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
 
        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locatorType, String locator) {
        Select dropdown = new Select(Find(locatorType, locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
 
        return values;
 
    }

    public List<WebElement> getListOfElements ( String locator ) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy( getBy("xpath", locator) ) );
        // return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath( locator ) ) );
        // return driver.findElements( By.xpath( locator ) );
    }

    public void selectItemInList(String locator, String elementToFind) {
        List<WebElement> elementList = getListOfElements(locator);

        for(WebElement e : elementList ) {
            if( e.getText().equals(elementToFind) ) {
                e.click();
            }
        }
    }
}
