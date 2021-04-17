package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/***
 * Class with the generic methods to work with the web elements that are used in the test cases
 */
public class BasePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    /***
     * Define WebDriverWait method for the project
     * @return WebDriverWait
     */
    public WebDriverWait getWait(){
        WebDriverWait wait =  new WebDriverWait(driver, 20);
        this.webDriverWait = wait;
        return webDriverWait;
    }

    /***
     *
     * @param element
     */
    public void findElementUntillVisibility(String element){
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
    }

    /***
     * Explicit wait until visibility of a web desired element
     * @param element Web Element in String format
     */
    public void findElementUntillVisibility(By element){
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    /***
     *
     * @param element Web Element in String format
     * @return
     */
    public String getTextElement(String element){
        return driver.findElement(By.cssSelector(element)).getText();
    }

    /***
     * Select a elemento from the dropdown days
     * @param element
     * @param opcion
     */
    public void selectValueDropdown(WebElement element, String opcion){
        Select selectObject = new Select(element);
        selectObject.selectByValue(opcion);
    }

    /***
     * Select a values from the multiselect list
     * @param element
     */
    public void selectValueMultiselect(String element){
        WebElement multiSelect = getDriver().findElement(By.cssSelector(element));
    }

    /***
     * Click in the button First Selected
     * @param element
     */
    public void clickButtonFirstSelect(String element){
        WebElement btnFirstSelect = getDriver().findElement(By.cssSelector(element));
    }

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }




}
