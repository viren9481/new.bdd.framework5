package step_def;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.BasketPage;
import pages.DescreptionPage;
import pages.ResultPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BasketSteps
{
    ResultPage resultPage= new ResultPage();
    DescreptionPage descreptionPage= new DescreptionPage();
    BasketPage basketPage= new BasketPage();

    @And("^i select any product$")
    public void iSelectAnyProduct()
    {
            resultPage.getRandomProduct();
    }

    @And("^i add product to basket$")
    public void iAddProductToBasket()
    {
descreptionPage.addToTrolly();
descreptionPage.goToTrolly();
    }

    @Then("^the product should be in the basket$")
    public void theProductShouldBeInTheBasket()
    {
List<String> actualProduct = basketPage.productInBasket();
assertThat(actualProduct,hasItem(ResultPage.selectedProduct));
    }
}
