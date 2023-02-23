import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import cz.cvut.fel.ts1.Main;
public class factTest {

    @Test
    public void factorialTest() {
        Assertions.assertEquals( 2, Main.factorialRecursive( 2 ) );
    }

}
