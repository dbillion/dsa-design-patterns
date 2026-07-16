package dp.behavioral.iterator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class IteratorDemoTest {
    @Test void rangeSums() {
        var sum = 0; for (int i : new IteratorDemo.Range(1, 5)) sum += i;
        assertEquals(15, sum);
    }
}
