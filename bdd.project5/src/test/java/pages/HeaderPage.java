package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends DriverManager
{

    public static String searchItem;

    @FindBy(id = "searchTerm")
    private WebElement searchTxtBox;

    @FindBy(className = "argos-header__search-button" )
    private WebElement magniFireGlass;

    @FindBy(className = "search-title__term")
    private WebElement getHeaderTxt;

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
    public void getSearchProduct(String item)
    {
        searchItem = item;
        searchTxtBox.sendKeys(item);
        magniFireGlass.click();
    }

    public String getProductResult()
    {
        return getHeaderTxt.getText();
    }
}
