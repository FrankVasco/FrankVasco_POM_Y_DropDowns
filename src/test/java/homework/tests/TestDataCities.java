package homework.tests;

import org.testng.annotations.DataProvider;

public class TestDataCities {

    @DataProvider(name="InputDataCities")
    public Object[][] getDays(){
        Object[][] obj = new Object[][]{
                {"California"}, {"Florida"}, {"New Jersey"}, {"New York"}, {"Ohio"}, {"Texas"}, {"Pennsylvania"},
                {"Washington"}
        };
        return obj;
    }
}
