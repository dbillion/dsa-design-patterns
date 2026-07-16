package dp.creational.builder;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BuilderDemoTest {
    @Test void buildsImmutable() {
        var e = new BuilderDemo.Email.Builder().to("a@x.com").subject("Hi").body("B").cc("c@x.com").build();
        assertEquals("a@x.com", e.to());
        assertEquals(1, e.cc().size());
        assertThrows(UnsupportedOperationException.class, () -> e.cc().add("x"));
    }
}
