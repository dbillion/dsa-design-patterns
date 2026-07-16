package dp.behavioral.chain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ChainDemoTest {
    @Test void errorLevelHandledByError() {
        var chain = java.util.List.<ChainDemo.Handler>of(new ChainDemo.Info(), new ChainDemo.Warn(), new ChainDemo.Error());
        var out = chain.stream().map(h -> h.handle(3, "boom")).filter(java.util.Optional::isPresent).map(java.util.Optional::get).findFirst();
        assertTrue(out.orElse("").startsWith("ERROR"));
    }
}
