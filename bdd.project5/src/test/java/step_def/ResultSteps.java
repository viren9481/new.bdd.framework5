package step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ResultPage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResultSteps
{
    ResultPage resultPage= new ResultPage();


    @And("^i apply filter \"([^\"]*)\" on result$")
    public void iApplyFilterOnResult(String filterChoice)
    {

        resultPage.selectByFilter(filterChoice);
    }

    @Then("^i can see all product \"([^\"]*)\" are filtered \"([^\"]*)\"$")
    public void iCanSeeAllProductAreFiltered(String filter, String filterValue)
    {
        if (filter.equalsIgnoreCase("review"))
        {
          List<Double> actual =  resultPage.getAllProductRatings();
       //     System.out.println(actual);
          assertThat(actual,everyItem(greaterThanOrEqualTo(Double.parseDouble(filterValue))));

        }

        if (filter.equalsIgnoreCase("range"))
        {
             List<Double> actual =resultPage.getAllPriceOnProduct();
        //    System.out.println(actual);
           List<String> rangeList =Arrays.asList(filterValue.split("-"));
           double min = Double.parseDouble(rangeList.get(0));
           double max = Double.parseDouble(rangeList.get(1));
           assertThat(actual,everyItem(is(both(greaterThanOrEqualTo(min)).and(lessThanOrEqualTo(max)))));

        }
    }
}
