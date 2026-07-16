package dp.structural.bridge;

/** Bridge — shape (abstraction) decoupled from renderer (implementation). */
public final class BridgeDemo {
    public interface Renderer { String render(String shape, String color); }
    public static final class VectorRenderer implements Renderer {
        public String render(String s, String c) { return "Vector " + s + " in " + c; }
    }
    public static final class RasterRenderer implements Renderer {
        public String render(String s, String c) { return "Raster " + s + " in " + c; }
    }
    public record Shape(String name, Renderer r, String color) {
        public String draw() { return r.render(name, color); }
    }

    public static void main(String[] args) {
        var s = new Shape("Circle", new VectorRenderer(), "red");
        System.out.println(s.draw());
    }
}
