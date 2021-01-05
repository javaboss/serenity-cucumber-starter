package caffinateme;

import caffinateme.steps.Customer;
import caffinateme.steps.UserRegistrationClient;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class UserRegistrationStepDefinitons {
    @Steps
    UserRegistrationClient userRegistrations;

    @Steps (shared = true)
    Customer customer;

    @Given("(.*) has a Caffinate-Me account")
    public void userHasACaffinateMeAccount(String userName) {
        userRegistrations.registerUser(customer);
        customer.isCalled(userName);
    }


}
