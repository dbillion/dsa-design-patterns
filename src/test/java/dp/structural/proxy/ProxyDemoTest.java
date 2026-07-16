package dp.structural.proxy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProxyDemoTest {
    @Test void lazyRender() {
        ProxyDemo.Image img = new ProxyDemo.ProxyImage("pic.png");
        assertEquals("rendered pic.png", img.render());
    }
}
