package caffinateme;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class OrderCoffeeSteps {
    @Steps
    Customer cathy;

    @Steps(shared = true)
    Barrista barry;

    String cathysOrder;

    @Given("(.*) is (\\d+) meters? from the coffee shop")
    public void cathy_is_n_meters_from_the_coffee_shop(String name, int distanceInMeters) throws Exception {
        cathy.notifyDistanceFromShop(distanceInMeters);
    }

    @When("Cathy (?:orders|has ordered) a (.*)$")
    public void cathy_orders_a(String order) throws Exception {
        cathysOrder = order;
        cathy.placesOrderFor(cathysOrder);
    }

    @Then("Barry should receive the order$")
    public void barry_should_receive_the_order() throws Exception {
        barry.shouldHaveAPendingOrderFor(cathysOrder);
    }

    @Then("^Barry should know that the coffee is Urgent$")
    public void barry_should_know_that_the_coffee_is_Urgent() throws Exception {
        assertThat(barry.getUrgentOrders(), hasItem(cathysOrder));
    }
}
