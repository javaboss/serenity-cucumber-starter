package caffinateme;

import java.util.Objects;

public class OrderReceipt {
    private final long customerId;
    private final int quanity;
    private final String product;

    public OrderReceipt(long customerId, int quanity, String product) {
        this.customerId = customerId;
        this.quanity = quanity;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderReceipt that = (OrderReceipt) o;
        return customerId == that.customerId && quanity == that.quanity && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, quanity, product);
    }

    @Override
    public String toString() {
        return "OrderReceipt{" +
                "customerId=" + customerId +
                ", quanity=" + quanity +
                ", product='" + product + '\'' +
                '}';
    }
}
