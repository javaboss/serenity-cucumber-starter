package caffinateme;

import caffinateme.steps.Customer;
import caffinateme.steps.UserRegistrationClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderACoffeeStepDefinitions {

    @Steps
    UserRegistrationClient userRegistrations;

    @Steps
    Customer cathy;

    @Given("Cathy haws a Caffinate-Me account")
    public void userHasACaffinateMeAccount() {
        userRegistrations.registerUser(cathy);
    }

    OrderReceipt orderReceipt;

    @When("^s?he orders a (.*)$")
    public void sheOrdersA(String order) throws Throwable {
        orderReceipt = cathy.placesAnOrderFor(1, order);
    }
}
