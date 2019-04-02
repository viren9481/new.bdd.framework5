import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;
import org.junit.Test;

public class Hooks

{
    DriverManager driverManager=new DriverManager();

    @Before
    public void setUp()
    {
    driverManager.runOnLocalHost();
    driverManager.navigateTo("https://www.argos.co.uk/");
    driverManager.maxBrowser();
    driverManager.handleCookie();
    //driverManager.closeBrowser();
    }

    @After
    public void tearDown()
    {
        driverManager.closeBrowser();
    }

}
