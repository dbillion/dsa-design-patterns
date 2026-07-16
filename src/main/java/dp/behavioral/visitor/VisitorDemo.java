package dp.behavioral.visitor;

import java.util.*;

/** Visitor — dispatch on shape type without instanceof. */
public final class VisitorDemo {
    public sealed interface Shape permits Circle, Rect {
        String accept(Visitor v);
    }
    public record Circle(double r) implements Shape { public String accept(Visitor v) { return v.visit(this); } }
    public record Rect(double w, double h) implements Shape { public String accept(Visitor v) { return v.visit(this); } }
    public interface Visitor { String visit(Circle c); String visit(Rect r); }
    public static final class AreaVisitor implements Visitor {
        public String visit(Circle c) { return "circle area " + (Math.PI * c.r() * c.r()); }
        public String visit(Rect r) { return "rect area " + (r.w() * r.h()); }
    }

    public static void main(String[] args) {
        var shapes = List.<Shape>of(new Circle(2), new Rect(3, 4));
        var v = new AreaVisitor();
        shapes.forEach(s -> System.out.println(s.accept(v)));
    }
}
