package dp.behavioral.memento;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MementoDemoTest {
    @Test void restore() {
        var e = new MementoDemo.Editor(); e.set("v1"); var snap = e.save(); e.set("v2");
        e.restore(snap); assertEquals("v1", e.text());
    }
}
