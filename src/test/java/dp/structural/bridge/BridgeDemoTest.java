package dp.structural.bridge;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeDemoTest {
    @Test void vectorVsRaster() {
        var v = new BridgeDemo.Shape("Circle", new BridgeDemo.VectorRenderer(), "red");
        var r = new BridgeDemo.Shape("Circle", new BridgeDemo.RasterRenderer(), "red");
        assertTrue(v.draw().startsWith("Vector"));
        assertTrue(r.draw().startsWith("Raster"));
    }
}
