package dp.structural.decorator;

/** Decorator — coffee with add-ons. */
public final class DecoratorDemo {
    public interface Coffee { String desc(); int cost(); }
    public record Basic(String name, int base) implements Coffee {
        public String desc() { return name; } public int cost() { return base; }
    }
    public record WithMilk(Coffee c) implements Coffee {
        public String desc() { return c.desc() + "+milk"; } public int cost() { return c.cost() + 2; }
    }
    public record WithSugar(Coffee c) implements Coffee {
        public String desc() { return c.desc() + "+sugar"; } public int cost() { return c.cost() + 1; }
    }

    public static void main(String[] args) {
        Coffee c = new WithSugar(new WithMilk(new Basic("Espresso", 5)));
        System.out.println(c.desc() + " = $" + c.cost());
    }
}
