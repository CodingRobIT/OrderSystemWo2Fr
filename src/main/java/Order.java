import java.util.Map;

public class Order {

private String id;
private Map<String, Product> orderProducts;

    public Order(String id, Map<String, Product> orderProducts) {
        this.id = id;
        this.orderProducts = orderProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Map<String, Product> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        return getOrderProducts() != null ? getOrderProducts().equals(order.getOrderProducts()) : order.getOrderProducts() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrderProducts() != null ? getOrderProducts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
