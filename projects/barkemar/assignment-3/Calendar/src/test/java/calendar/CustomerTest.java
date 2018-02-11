package calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testDiscount() {
     //   Customer theCustomer = new Customer();
   //     assertEquals(0, theCustomer.discountFor(5));
 //       assertEquals(20, theCustomer.discountFor(20));

        //testing:
        /*
            if (aNumberOfOrders > 10) {
                 return 20;
            }
            return 0;
        */
        Customer theCustomer = new Customer();
        assertEquals(0, theCustomer.discountFor(5));
        assertEquals(0, theCustomer.discountFor(9));
        assertEquals(0, theCustomer.discountFor(10));
        assertEquals(20, theCustomer.discountFor(11));
        assertEquals(20, theCustomer.discountFor(20));

    }
}