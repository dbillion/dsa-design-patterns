package dp.behavioral.visitor;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VisitorDemoTest {
    @Test void visitsShapes() {
        var v = new VisitorDemo.AreaVisitor();
        assertTrue(new VisitorDemo.Circle(2).accept(v).startsWith("circle"));
        assertTrue(new VisitorDemo.Rect(3, 4).accept(v).contains("12"));
    }
}
