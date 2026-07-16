package dp.structural.decorator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorDemoTest {
    @Test void layeredCost() {
        DecoratorDemo.Coffee c = new DecoratorDemo.WithSugar(new DecoratorDemo.WithMilk(new DecoratorDemo.Basic("Esp", 5)));
        assertEquals(8, c.cost());
        assertTrue(c.desc().contains("milk") && c.desc().contains("sugar"));
    }
}
