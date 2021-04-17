package homework.tests;

import org.testng.annotations.DataProvider;

public class TestDataDays {

    @DataProvider(name="InputDataDays")
    public Object[][] getDays(){
        Object[][] obj = new Object[][]{
                {"Sunday"}, {"Monday"}, {"Tuesday"}, {"Wednesday"}, {"Thursday"}, {"Friday"}, {"Saturday"}
        };
        return obj;
    }

}
