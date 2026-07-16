package dp.behavioral.template;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TemplateDemoTest {
    @Test void makes() {
        assertTrue(new TemplateDemo.Tea().make().contains("steep tea"));
        assertTrue(new TemplateDemo.Coffee().make().contains("brew coffee"));
    }
}
