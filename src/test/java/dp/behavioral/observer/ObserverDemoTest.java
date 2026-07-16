package dp.behavioral.observer;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ObserverDemoTest {
    @Test void notifiesSubscribers() {
        var s = new ObserverDemo.Subject();
        var got = new java.util.ArrayList<String>();
        s.subscribe(got::add);
        s.publish("hi");
        assertEquals(java.util.List.of("hi"), got);
    }
}
