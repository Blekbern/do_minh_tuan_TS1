package hw04Test;

import cz.cvut.fel.ts1.hw04.shop.StandardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StandardItemTest {

    StandardItem test = new StandardItem( 1, "Name test", 99.99f, "Category test", 100 );

    private int idTest;
    private String nameTest;
    private float priceTest;
    private String categoryTest;
    private int loyalPointsTest;

    @Test
    public void StandardItem_testConstructor() {
        idTest = 1;
        nameTest = "Name test";
        priceTest = 99.99f;
        categoryTest = "Category test";
        loyalPointsTest = 100;

        Assertions.assertEquals( test.getID(), idTest );
        Assertions.assertEquals( test.getName(), nameTest );
        Assertions.assertEquals( test.getPrice(), priceTest );
        Assertions.assertEquals( test.getCategory(), categoryTest );
        Assertions.assertEquals( test.getLoyaltyPoints(), loyalPointsTest );
    }

    @Test
    public void StandardItem_testWithDifParam_expectedId1() {
        idTest = 2;
        nameTest = "Name test";
        priceTest = 99.99f;
        categoryTest = "Category test";
        loyalPointsTest = 100;

        Assertions.assertEquals( test.getID(), idTest ); // fail
        Assertions.assertEquals( test.getName(), nameTest );
        Assertions.assertEquals( test.getPrice(), priceTest );
        Assertions.assertEquals( test.getCategory(), categoryTest );
        Assertions.assertEquals( test.getLoyaltyPoints(), loyalPointsTest );
    }

    @Test
    public void copyTest_testAndCopyTest() {
        StandardItem copyTest = test.copy();

        Assertions.assertEquals( true, copyTest.getID() == test.getID() );
        Assertions.assertEquals( true, copyTest.getName() == test.getName() );
        Assertions.assertEquals( true, copyTest.getPrice() == test.getPrice() );
        Assertions.assertEquals( true, copyTest.getCategory() == test.getCategory() );
        Assertions.assertEquals( true, copyTest.getLoyaltyPoints() == test.getLoyaltyPoints() );
    }

//    @ParameterizedTest
//    public void equals_
}
