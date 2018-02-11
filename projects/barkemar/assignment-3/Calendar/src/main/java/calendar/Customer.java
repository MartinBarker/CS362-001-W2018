package calendar;

public class Customer {

    public int discountFor(int aNumberOfOrders) {
        if (aNumberOfOrders > 10) {
            return 20;
        }
        return 0;
    }
}