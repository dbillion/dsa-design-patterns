package dp.structural.flyweight;

import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightDemoTest {
    @Test void sharedGlyphs() {
        var f = new FlyweightDemo.GlyphFactory();
        var t = new FlyweightDemo.Text(List.of(f.get('a'), f.get('b'), f.get('a')));
        assertEquals(3, t.glyphs().size());
        assertEquals(2, t.distinctCount());
        assertSame(f.get('a'), f.get('a'));
    }
}
