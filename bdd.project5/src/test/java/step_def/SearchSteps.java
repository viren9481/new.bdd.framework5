package step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import pages.HeaderPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SearchSteps
{
    HeaderPage headerPage= new HeaderPage();

    @Given("^i am on homepage$")
    public void i_am_on_homepage()
    {
     String actualUrl = headerPage.getUrl();
     assertThat(actualUrl,endsWith(".co.uk/"));
//     assertThat(actualUrl,endsWith(".com"));
    }

    @When("^i search for product \"([^\"]*)\"$")
    public void i_search_for_product(String item)
    {
        headerPage.getSearchProduct(item);
    }

    @Then("^i should be able to see respective result$")
    public void i_should_be_able_to_see_respective_result()
    {
        String actual =headerPage.getProductResult();
        assertThat(actual,is(equalToIgnoringCase(HeaderPage.searchItem)));
  //      assertThat(actual,is(equalToIgnoringCase("puma")));
    }



}
