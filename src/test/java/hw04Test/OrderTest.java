package hw04Test;

import cz.cvut.fel.ts1.hw04.shop.Item;
import cz.cvut.fel.ts1.hw04.shop.Order;
import cz.cvut.fel.ts1.hw04.shop.ShoppingCart;
import cz.cvut.fel.ts1.hw04.shop.StandardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderTest {

    private Order orderTest1; // with state
    private Order orderTest1a; // with null val
    private Order orderTest2; // without state
    private ShoppingCart cart;

    @BeforeEach
    public void initAttributes() {
        cart = new ShoppingCart(); // empty cart;
        orderTest1 = new Order( cart, "Name test", "Address test", 1 );
        orderTest1a = new Order( cart, null, "Address test1a", 11 );
        orderTest2 = new Order( cart, "Name test2", "Address test2" );
    }

    @Test
    public void testConstructor1() {
        Assertions.assertEquals( cart.getCartItems(), orderTest1.getItems() );
        Assertions.assertEquals( "Name test", orderTest1.getCustomerName() );
        Assertions.assertEquals( "Address test", orderTest1.getCustomerAddress() );
        Assertions.assertEquals( 1, orderTest1.getState() );
        Assertions.assertNotNull( orderTest1.getCustomerName() );
    }

    @Test
    public void testConstructor1_filledCart() {
        ArrayList<StandardItem> list = new ArrayList<>();
        StandardItem item1 = new StandardItem( 1, "Name test1", 1.99f, "Category test1", 10 );
        StandardItem item2 = new StandardItem( 2, "Name test2", 2.99f, "Category test2", 20 );
        StandardItem item3 = new StandardItem( 3, "Name test3", 3.99f, "Category test3", 30 );
        StandardItem item4 = new StandardItem( 4, "Name test4", 4.99f, "Category test4", 40 );
        StandardItem item5 = new StandardItem( 5, "Name test5", 5.99f, "Category test5", 50 );
        StandardItem item6 = new StandardItem( 6, "Name test6", 6.99f, "Category test6", 60 );
        list.add( item1 );
        list.add( item2 );
        list.add( item3 );
        list.add( item4 );
        list.add( item5 );
        list.add( item6 );
        for( StandardItem item : list ) {
            cart.addItem( item );
        }

        Order newOrder = new Order( cart, "Name test", "Address test", 1 );
        Assertions.assertEquals( cart.getCartItems(), newOrder.getItems() );
        Assertions.assertEquals( "Name test", newOrder.getCustomerName() );
        Assertions.assertEquals( "Address test", newOrder.getCustomerAddress() );
        Assertions.assertEquals( 1, newOrder.getState() );
        Assertions.assertNotNull( newOrder.getCustomerName() );

    }

    @Test
    public void testConstructor1_testIfNotNull_testFailed() {
        Assertions.assertNotNull( orderTest1a.getCustomerName() );
    }

    @Test
    public void testConstructor2() {
        Assertions.assertEquals( cart.getCartItems(), orderTest2.getItems() );
        Assertions.assertEquals( "Name test2", orderTest2.getCustomerName() );
        Assertions.assertEquals( "Address test2", orderTest2.getCustomerAddress() );
    }
}
