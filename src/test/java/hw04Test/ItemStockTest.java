package hw04Test;

import cz.cvut.fel.ts1.hw04.shop.StandardItem;
import cz.cvut.fel.ts1.hw04.storage.ItemStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ItemStockTest {
    private StandardItem item;
    private ItemStock itemStock;

    @BeforeEach
    public void initAttr() {
        item = new StandardItem( 1, "Name test", 1.99f, "Category test", 10 );
        itemStock = new ItemStock( item );
    }

    @Test
    public void testConstructor() {
        Assertions.assertEquals( item, itemStock.getItem() );
    }

    @ParameterizedTest( name = "Increasing by {0} amount should give {1} amount" )
    @CsvSource({
            "2, 2",
            "-1, -1",
            "100, 100",
            "0, 0",
            "-0, 0"
    })
    public void increaseItemCount_increaseByParam( int x, int result ) {
        itemStock.IncreaseItemCount( x );
        Assertions.assertEquals( result, itemStock.getCount() );
    }

    @ParameterizedTest( name = "Decreasing by {0} amount should give {1} amount" )
    @CsvSource({
            "2, -2",
            "-1, 1",
            "100, -100",
            "0, 0",
            "-0, 0"
    })
    public void decreaseItemCount_decreaseByParam( int x, int result ) {
        itemStock.decreaseItemCount( x );
        Assertions.assertEquals( result, itemStock.getCount() );
    }

}
