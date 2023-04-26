package hw04Test;

import cz.cvut.fel.ts1.hw04.shop.Item;
import cz.cvut.fel.ts1.hw04.shop.Order;
import cz.cvut.fel.ts1.hw04.shop.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderTest {

    private Order orderTest1; // with state
    private Order orderTest2; // without state
    private ShoppingCart cart;

    @BeforeAll
    public void initAttributes() {
        cart = new ShoppingCart(); // empty cart;
        orderTest1 = new Order( cart, "Name test", "Address test", 1 );
        orderTest2 = new Order( cart, "Name2 test", "Address2 test" );
    }

    @Test
    public void testConstructor1() {
        Assertions.assertEquals( cart.getCartItems(), orderTest1.getItems() );
        Assertions.assertEquals( "Name test", orderTest1.getCustomerName() );
        Assertions.assertEquals( "Address test", orderTest1.getCustomerAddress() );
        Assertions.assertEquals( 1, orderTest1.getState() );
    }

    @Test
    public void testConstructor2() {
        Assertions.assertEquals( cart.getCartItems(), orderTest2.getItems() );
        Assertions.assertEquals( "Name test2", orderTest2.getCustomerName() );
        Assertions.assertEquals( "Address test2", orderTest2.getCustomerAddress() );
    }
}
