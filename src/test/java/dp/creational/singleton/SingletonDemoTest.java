package dp.creational.singleton;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonDemoTest {
    @Test void sameInstance() {
        assertSame(dp.creational.singleton.SingletonDemo.Singleton.INSTANCE,
                   dp.creational.singleton.SingletonDemo.Singleton.INSTANCE);
    }
}
