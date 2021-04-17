package homework.pages;

import homework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage extends BasePage {

    //private WebDriver driver;

    public DropdownPage(WebDriver driver){
        super(driver);
        //this.driver = driver;

    }

    @FindBy(css="select[class='form-control']")
    private WebElement dayDropdown;

    String dayLabel = "p[class='selected-value']";

    @FindBy(css="select#multi-select")
    private WebElement multiSelectList;

    private String multiSelectLabel = "p[class='getall-selected']";

    private String btnFirstSelected = "button[id='printMe']";



    /***
     * Get the text from the labels
     * @return
     */
    public String getDayLabel(){
        verifyDayLabelInfo();
        return getTextElement(dayLabel);
    }

    /***
     * Get info from the label in the multiselect section
     * @return
     */
    public String getOptionSelectedFromMultiselect(){
        verifyLabelMultiselect();
        return getTextElement(multiSelectLabel);
    }


    /***
     * Validate that the day label is displayed
     */
    public void verifyDayLabelInfo(){

        findElementUntillVisibility(dayLabel);
    }

    /***
     * Validate the multiselect label is displayed
     */
    public void verifyLabelMultiselect(){

        findElementUntillVisibility(multiSelectLabel);
    }

    /***
     * Selects an option from the dayDropdown
     * @param option
     */
    public void selectElementDropdown(String option){
        getWait().until(ExpectedConditions.elementToBeClickable(dayDropdown));
        WebElement selectDayDropdown = getDriver().findElement(By.cssSelector("dayDropdown"));
        this.selectValueDropdown(selectDayDropdown, option);
    }

    /***
     * Selects a option from the multislect
     * @param city
     */
    public void selectOptionMultiselect(String city){
        Select dropdownCities = new Select(getDriver().findElement(By.cssSelector(multiSelectLabel)));
        dropdownCities.selectByVisibleText(city);
        clickButtonFirstSelect(btnFirstSelected);
    }

    /***
     * Click in the button first selected
     */
    public void clickButon(){
        clickButtonFirstSelect(btnFirstSelected);
    }


}
