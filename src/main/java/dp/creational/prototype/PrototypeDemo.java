package dp.creational.prototype;

/** Prototype — clone via copy constructor on a record-ish class. */
public final class PrototypeDemo {
    public record Point(int x, int y) {}
    public record Shape(Point p, String color) {
        public Shape cloneAt(Point np) { return new Shape(np, color); }
    }

    public static void main(String[] args) {
        var s = new Shape(new Point(0, 0), "red");
        var c = s.cloneAt(new Point(5, 5));
        System.out.println("orig=" + s + " clone=" + c);
    }
}
