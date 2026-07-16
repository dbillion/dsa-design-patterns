package dp.structural.adapter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AdapterDemoTest {
    @Test void convertsToCelsius() {
        var c = new AdapterDemo.Adapter(new AdapterDemo.FahrenheitSensor());
        assertEquals(37.0, c.readC(), 0.001);
    }
}
