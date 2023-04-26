package hw04Test;

import  cz.cvut.fel.ts1.hw04.archive.*;
import cz.cvut.fel.ts1.hw04.shop.Order;
import cz.cvut.fel.ts1.hw04.shop.ShoppingCart;
import cz.cvut.fel.ts1.hw04.shop.StandardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class PurchasesArchiveTest {

    private ArrayList<StandardItem> itemsOrder;
    private PurchasesArchive archive;

    @BeforeEach
    public void initAttr() {
        archive = new PurchasesArchive();
        itemsOrder = new ArrayList<StandardItem>();
    }

    @Test
    public void testPrintItemPurchaseStatistics() {
        StandardItem item1 = new StandardItem(1, "Name test1", 1.99f, "Category test", 10);
        StandardItem item1a = new StandardItem(1, "Name test1", 1.99f, "Category test", 10);
        StandardItem item1b = new StandardItem(1, "Name test1", 1.99f, "Category test", 10);
        StandardItem item2 = new StandardItem(2, "Name test2", 2.99f, "Category test", 20);
        StandardItem item3 = new StandardItem(3, "Name test3", 3.99f, "Category test", 30);
        StandardItem item4 = new StandardItem(4, "Name test4", 4.99f, "Category test", 40);

        itemsOrder.add(item1);
        itemsOrder.add(item1a);
        itemsOrder.add(item1b);
        itemsOrder.add(item2);
        itemsOrder.add(item3);
        itemsOrder.add(item4);

        // wtf gotta make a whole new cart with a whole new order to put an order in an archive gg
        ShoppingCart cart = new ShoppingCart();
        for (StandardItem i : itemsOrder) {
            cart.addItem(i);
        }
        Order order = new Order(cart, "Name order", "Address test", 1);
        archive.putOrderToPurchasesArchive(order);
        // ----------------------------------------------------------------------------------------------------

        // saving output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut( new PrintStream( outputStream ) );
        archive.printItemPurchaseStatistics();

        String expectedOutput =
                "ITEM PURCHASE STATISTICS:\n"+
                "ITEM  Item   ID 1   NAME Name test1   CATEGORY Category test   PRICE 1.99   LOYALTY POINTS 10   HAS BEEN SOLD 3 TIMES\n"+
                "ITEM  Item   ID 2   NAME Name test2   CATEGORY Category test   PRICE 2.99   LOYALTY POINTS 20   HAS BEEN SOLD 1 TIMES\n"+
                "ITEM  Item   ID 3   NAME Name test3   CATEGORY Category test   PRICE 3.99   LOYALTY POINTS 30   HAS BEEN SOLD 1 TIMES\n"+
                "ITEM  Item   ID 4   NAME Name test4   CATEGORY Category test   PRICE 4.99   LOYALTY POINTS 40   HAS BEEN SOLD 1 TIMES\n";
        Assertions.assertEquals( outputStream.toString(), expectedOutput );
    }

}
