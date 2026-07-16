package dp.creational.abstractfactory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryDemoTest {
    @Test void macVsWin() {
        var mac = AbstractFactoryDemo.getFactory("mac");
        var win = AbstractFactoryDemo.getFactory("win");
        assertEquals("MacBtn", mac.createButton().label());
        assertEquals("WinChk", win.createCheckbox().label());
        assertThrows(IllegalArgumentException.class, () -> AbstractFactoryDemo.getFactory("linux"));
    }
}
