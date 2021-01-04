package caffinateme;

import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class Barrista {
    public List<String> getPendingOrders() {
        List<String> results = new ArrayList<>();
        results.add("large cappuccino");

        return results;
    }

    public List<String> getUrgentOrders() {
        List<String> results = new ArrayList<>();
        results.add("large cappuccino");

        return results;
    }

    @Step
    public void shouldHaveAPendingOrderFor(String someOrder) {
        assertThat(getPendingOrders(), hasItem(someOrder));
    }
}
