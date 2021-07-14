package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultPage extends DriverManager
{

    DriverManager driverManager= new DriverManager();
    @FindBy(css = ".ac-facet__label")
    private List<WebElement> filterBy;

    @FindBy(css = ".ac-star-rating")
    private List<WebElement> reviewOnImage;


    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> priceOnProduct;

    @FindBy(css = ".ac-product-name.ac-product-card__name")
    private List<WebElement> selectAnyProduct;

    public static String selectedProduct;

    public void selectByFilter(String filterChoice)
    {
        List<String> selectedFilter = new ArrayList<>(); // filter in " " so we use String here

        for (WebElement filterelement:filterBy)
        {
         if (filterelement.getText().equalsIgnoreCase(filterChoice))
         {
             waitUntilElementClickable(filterelement).click();
             break;
         }
        }
        waitUntilElementVisible(By.cssSelector(".icon--loading"));

    }

    public List<Double> getAllProductRatings()
    {
        List<Double> allRatings =new ArrayList<>(); // ratings are in double so we use list<Double>

        for (WebElement filterElement:reviewOnImage)
        {

         //   driverManager.applyImplicityWait();
            String valueInString =filterElement.getAttribute("data-star-rating");
         //String valueInString= filterElement.getAttribute("data-star-rating");
         double valueInDouble = Double.parseDouble(valueInString);
         allRatings.add(valueInDouble);

        }
        return allRatings;
    }

    public List<Double> getAllPriceOnProduct()
    {
        List<Double> allProduct =new ArrayList<>();

        for (WebElement filterElement:priceOnProduct)
        {
         //   driverManager.applyImplicityWait();
       //  String selectedProduct =filterElement.getText(); // not required
         double valueInDouble = Double.parseDouble(filterElement.getText().replace("£"," "));
         allProduct.add(valueInDouble);


        }
        return allProduct;
    }

    public void getRandomProduct()
    {
      int totalProduct=   selectAnyProduct.size();

      if (totalProduct==0)
      {
          throw new RuntimeException("no product found");
      }

        Random random =new Random();
      int randomProduct =random.nextInt(totalProduct);
      WebElement selectedWebElement =selectAnyProduct.get(randomProduct);
      selectedProduct= selectedWebElement.getText();
      selectedWebElement.click();

    }
}

