package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends DriverManager
{
    @FindBy(css = "a[data-e2e='product-name']")
    private List<WebElement> productNameInBasket;

    public List<String> productInBasket()
    {
        List<String> getProductName = new ArrayList<>();
        for (WebElement selectedElement:productNameInBasket)
        {
           getProductName.add(selectedElement.getText());

        }
        return getProductName;
    }
}
