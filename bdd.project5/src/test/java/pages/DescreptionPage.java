package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DescreptionPage extends DriverManager
{

    @FindBy(xpath = "//div[4]/div[2]/button[1]/span[1]/span[1]")
    private WebElement addToTrollyBtn;

    @FindBy(xpath = "//a[@class='button button--full xs-hidden sm-block']")
    private WebElement goToTrollyBtn;


    public void addToTrolly()
    {
        waitUntilElementClickable(addToTrollyBtn).click();
      //  addToTrollyBtn.click();
    }

    public void goToTrolly()
    {
//goToTrollyBtn.click();
        waitUntilElementClickable(goToTrollyBtn).click();
    }
}
