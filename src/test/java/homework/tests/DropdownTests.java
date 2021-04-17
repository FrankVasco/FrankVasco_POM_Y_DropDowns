package homework.tests;

import homework.pages.DropdownPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTests extends BaseTests {

    DropdownPage dropdownPage;

    @BeforeTest
    public void setup(){
        dropdownPage = new DropdownPage(driver);
    }


    @Test(description = "Dropdowns", dataProvider = "InputDataDays", dataProviderClass = TestDataDays.class)
    public void testLabelDropdown(String input){
        dropdownPage.selectElementDropdown(input);
        Assert.assertEquals(dropdownPage.getDayLabel(),"Day selected :- " + input);

    }


    @Test(description = "MultiselecList", dataProvider = "InputDataCities", dataProviderClass = TestDataCities.class)
    public void multiselectList(String input){
        dropdownPage.selectOptionMultiselect(input);
        dropdownPage.clickButon();

        Assert.assertEquals(dropdownPage.getOptionSelectedFromMultiselect(),"First selected option is : " + input);
    }

    @AfterTest
    public void cerrarPage(){
        dropdownPage.dispose();
    }

}
