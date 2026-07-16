package dp.structural.facade;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FacadeDemoTest {
    @Test void watchSequence() {
        var s = new FacadeDemo.HomeTheater().watch();
        assertEquals(3, s.size());
        assertTrue(s.contains("DVD on"));
    }
}
