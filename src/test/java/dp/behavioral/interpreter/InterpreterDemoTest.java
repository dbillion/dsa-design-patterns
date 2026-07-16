package dp.behavioral.interpreter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class InterpreterDemoTest {
    @Test void andEvaluates() {
        InterpreterDemo.Expr e = new InterpreterDemo.And(new InterpreterDemo.Var("a"), new InterpreterDemo.Var("b"));
        assertTrue(e.eval(java.util.Map.of("a", true, "b", true)));
        assertFalse(e.eval(java.util.Map.of("a", true, "b", false)));
    }
}
