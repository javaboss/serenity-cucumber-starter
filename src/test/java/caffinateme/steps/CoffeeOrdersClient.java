package caffinateme.steps;

import caffinateme.OrderReceipt;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrdersClient {

    List<Order> orders = new ArrayList<>();

    @Step
    public OrderReceipt placeOrder(long customerId, int quantity, String product) {
        Order order = new Order(customerId, quantity, product);
        orders.add(order);
        return order.getReceipt();
    }

    @Step
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Step
    public void updateCustomerEta(long customerId, int minutesAway) {
        orders.stream().filter(order -> order.getCustomerId() == customerId)
                .forEach(order -> order.updateETATo(minutesAway));
    }
}
