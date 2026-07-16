package dp.creational.prototype;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PrototypeDemoTest {
    @Test void cloneCopiesColorNewPoint() {
        var s = new PrototypeDemo.Shape(new PrototypeDemo.Point(0,0), "red");
        var c = s.cloneAt(new PrototypeDemo.Point(5,5));
        assertEquals("red", c.color());
        assertEquals(5, c.p().x());
        assertNotSame(s, c);
    }
}
