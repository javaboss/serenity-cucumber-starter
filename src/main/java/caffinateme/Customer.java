package caffinateme;

import net.thucydides.core.annotations.Step;

public class Customer {
    private int setDistanceFromShop;

    String actor;

    @Step("Notify caffinateme that the customer is {0} meters from the shop")
    public void notifyDistanceFromShop(int distanceInMeters) {
        this.setDistanceFromShop = distanceInMeters;
    }

    @Step("#actor places an order for {0}")
    public void placesOrderFor(String order) {
    }
}
