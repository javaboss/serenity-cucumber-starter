package caffinateme;

import caffinateme.steps.Barista;
import caffinateme.steps.Customer;
import caffinateme.steps.Order;
import caffinateme.steps.UserRegistrationClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OrderACoffeeStepDefinitions {

    @Steps
    UserRegistrationClient userRegistrations;

    @Steps
    Customer cathy;

    @Steps
    Barista barry;

    @Given("Cathy haws a Caffinate-Me account")
    public void userHasACaffinateMeAccount() {
        userRegistrations.registerUser(cathy);
    }

    OrderReceipt orderReceipt;

    @When("^s?he orders a (.*)$")
    public void sheOrdersA(String order) throws Throwable {
        orderReceipt = cathy.placesAnOrderFor(1, order);
    }

    @Then("^Barry should receive the order$")
    public void barryShouldReceiveTheOrder() {
        assertThat(barry.pendingOrders()).contains(Order.matching(orderReceipt));
    }
}
