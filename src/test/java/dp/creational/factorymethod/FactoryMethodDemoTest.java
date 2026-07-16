package dp.creational.factorymethod;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodDemoTest {
    @Test void createsCircleAndSquare() {
        var c = FactoryMethodDemo.create("circle", 2.0);
        var s = FactoryMethodDemo.create("square", 3.0);
        assertInstanceOf(FactoryMethodDemo.Circle.class, c);
        assertInstanceOf(FactoryMethodDemo.Square.class, s);
        assertThrows(IllegalArgumentException.class, () -> FactoryMethodDemo.create("blob", 1));
    }
}
