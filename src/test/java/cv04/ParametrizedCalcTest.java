package cv04;

import cz.cvut.fel.ts1.hw02.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParametrizedCalcTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest( name = "{0} plus {1} should be equal to {2}" )
    @CsvSource( {"1, 2, 3", "2, 3, 5", "-3, 5, 2", "1, 2, 1"} )
    public void add_addsAandB_returnC( int a, int b, int c ) {
        Assertions.assertEquals( c, calculator.sum(a, b) );
    }
}
