package dp.structural.composite;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CompositeDemoTest {
    @Test void nestedSize() {
        var d = new CompositeDemo.Directory("root");
        d.add(new CompositeDemo.File("a.txt", 10));
        var sub = new CompositeDemo.Directory("sub"); sub.add(new CompositeDemo.File("b.txt", 5));
        d.add(sub);
        assertEquals(15, d.size());
    }
}
