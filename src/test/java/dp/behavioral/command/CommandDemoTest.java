package dp.behavioral.command;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandDemoTest {
    @Test void undoRemovesLast() {
        var e = new CommandDemo.Editor(); e.execute("hello"); e.execute(" world"); e.undo();
        assertEquals("hello", e.text());
    }
}
