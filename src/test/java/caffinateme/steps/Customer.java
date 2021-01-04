package caffinateme.steps;

import caffinateme.OrderReceipt;
import cucumber.api.java.en.Given;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class Customer extends ScenarioActor {
    private long customerId;

    public void hasACustomerIdOf(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    @Step("#actor places an order for {0} {1}")
    public OrderReceipt placesAnOrderFor(int quantity, String product) {
        return null;
    }
}
