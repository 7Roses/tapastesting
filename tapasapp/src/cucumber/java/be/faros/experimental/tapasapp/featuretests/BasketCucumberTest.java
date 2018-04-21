package be.faros.experimental.tapasapp.featuretests;

import static org.assertj.core.api.Assertions.assertThat;

import be.faros.experimental.tapasapp.BaseCucumberTest;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasketCucumberTest extends BaseCucumberTest {

  @When("^the user creates a new basket$")
  public void the_user_creates_a_new_basket() {
    userBasketManagement.createNewBasket();
  }

  @Then("^the number of items in the basket with id (\\d+) equals (\\d+)$")
  public void an_empty_basket_exists_with_id(int id, int amount) {
    assertThat(userBasketManagement.retrieveListOfAllTapasOrdersInBasket(id).size()).isEqualTo(amount);
  }

  @After
  public void clear() {
    super.clearDatabase();
  }
}
