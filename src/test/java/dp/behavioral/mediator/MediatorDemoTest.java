package dp.behavioral.mediator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MediatorDemoTest {
    @Test void broadcasts() {
        var room = new MediatorDemo.ChatRoom();
        room.send("Alice", "hi"); room.send("Bob", "hello");
        assertEquals(2, room.log().size());
        assertTrue(room.log().get(0).startsWith("Alice"));
    }
}
