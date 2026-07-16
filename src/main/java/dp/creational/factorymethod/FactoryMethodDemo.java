package dp.creational.factorymethod;

/** Factory Method — sealed hierarchy of products, switch expression dispatch. */
public final class FactoryMethodDemo {
    public sealed interface Shape permits Circle, Square {}
    public record Circle(double r) implements Shape {}
    public record Square(double s) implements Shape {}

    public static Shape create(String kind, double v) {
        return switch (kind) {
            case "circle" -> new Circle(v);
            case "square" -> new Square(v);
            default -> throw new IllegalArgumentException("unknown: " + kind);
        };
    }

    public static void main(String[] args) {
        Shape c = create("circle", 2.0);
        Shape s = create("square", 3.0);
        System.out.println(c + " | " + s);
    }
}
