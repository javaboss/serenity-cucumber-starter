package caffinateme;

import caffinateme.steps.Barista;
import caffinateme.steps.Customer;
import caffinateme.steps.Order;
import caffinateme.steps.UserRegistrationClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OrderACoffeeStepDefinitions {

    @Steps (shared = true)
    Customer customer;

    @Steps
    Barista barry;

    OrderReceipt orderReceipt;

    @When("^(?:.*) (?:orders|has ordered) an? (.*)$")
    public void sheOrdersA(String order) throws Throwable {
        orderReceipt = customer.placesAnOrderFor(1, order);

        Serenity.setSessionVariable("orderReceipt").to(orderReceipt);
    }

    @Then("^Barry should receive the order$")
    public void barryShouldReceiveTheOrder() {
        assertThat(barry.pendingOrders()).contains(Order.matching(orderReceipt));
    }

    @Given("^Sarah has ordered: (.*)$")
    public void sarahHasOrdered(List<String> orders) throws Throwable {
        System.out.println("Orders: " + orders);
    }
}
