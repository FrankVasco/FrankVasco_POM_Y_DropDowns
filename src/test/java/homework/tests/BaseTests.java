package homework.tests;

import homework.pages.DropdownPage;
import homework.utils.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTests {

    public MyDriver myDriver;
    public WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

    }


}
