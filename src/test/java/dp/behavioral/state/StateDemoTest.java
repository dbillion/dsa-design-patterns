package dp.behavioral.state;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StateDemoTest {
    @Test void transition() {
        StateDemo.State s = new StateDemo.Idle();
        s = s.insert();
        assertTrue(s instanceof StateDemo.HasCoin);
    }
}
