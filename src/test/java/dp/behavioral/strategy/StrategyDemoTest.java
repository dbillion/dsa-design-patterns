package dp.behavioral.strategy;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StrategyDemoTest {
    @Test void naturalVsReverse() {
        var list = java.util.List.of(3, 1, 2);
        assertEquals(java.util.List.of(1, 2, 3), StrategyDemo.sort(list, Comparator.naturalOrder()));
        assertEquals(java.util.List.of(3, 2, 1), StrategyDemo.sort(list, Comparator.reverseOrder()));
    }
}
