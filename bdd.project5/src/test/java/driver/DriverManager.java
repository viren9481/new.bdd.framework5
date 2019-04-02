package driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager
{
    public DriverManager()
    {
        PageFactory.initElements(driver,this);
    }

    public static WebDriver driver;

    public  String browser="chrome";

    public void runOnLocalHost()
    {
        switch(browser)
        {
            case  "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "ie" :
                WebDriverManager.iedriver().setup();
                driver= new InternetExplorerDriver();
                break;
                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();

        }




    }
    public void navigateTo(String url)
    {
        driver.get(url);
    }
    public void maxBrowser()
    {
        driver.manage().window().maximize();
    }
public void handleCookie()
{
    driver.findElement(By.linkText("GOT IT")).click();
}
    public void applyImplicityWait()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebElement waitUntilElementClickable(WebElement element)
    {
      return  new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(element));
    }
    public Boolean waitUntilElementVisible(By by)
    {
        return new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void takeScreenShot(Scenario scenario)
    {
        byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot,"image/png");
    }

    public void closeBrowser()
    {
        driver.close();
    }
}