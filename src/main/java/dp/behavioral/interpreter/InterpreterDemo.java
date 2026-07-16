package dp.behavioral.interpreter;

import java.util.*;

/** Interpreter — tiny boolean expression: AND of two vars. */
public final class InterpreterDemo {
    public sealed interface Expr permits Var, And {
        boolean eval(Map<String, Boolean> ctx);
    }
    public record Var(String name) implements Expr {
        public boolean eval(Map<String, Boolean> c) { return c.getOrDefault(name, false); }
    }
    public record And(Expr l, Expr r) implements Expr {
        public boolean eval(Map<String, Boolean> c) { return l.eval(c) && r.eval(c); }
    }

    public static void main(String[] args) {
        Expr e = new And(new Var("a"), new Var("b"));
        System.out.println(e.eval(Map.of("a", true, "b", false)));
    }
}
