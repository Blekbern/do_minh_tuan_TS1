import cz.cvut.fel.ts1.hw02.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator test = new Calculator();

    @Test
    public void sum_5and1_return6() {
        Assertions.assertEquals( 6, test.sum(5, 1) );
    }

    @Test
    public void sum_neg5and1_returnNeg4() {
        Assertions.assertEquals( -4, test.sum(-5, 1) );
    }


    @Test
    public void subtract_4and2_return2() {
        Assertions.assertEquals( 2, test.subtract(4, 2) );
    }

    @Test
    public void multiply_7and3_return21() {
        Assertions.assertEquals( 21, test.multiply(7, 3) );
    }

    @Test
    public void divide_24and3_return8() {
        Assertions.assertEquals( 8, test.divide(24, 3) );
    }

    @Test
    public void divide_500and0_returnNaN() {
//        Assertions.assertThrows( "/ by zero", test.divide(500, 0) );
    }

}
